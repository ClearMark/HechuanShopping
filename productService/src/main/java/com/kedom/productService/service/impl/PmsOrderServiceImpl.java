package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsOrderDao;
import com.kedom.productService.entity.CancelOrderVO;
import com.kedom.productService.entity.OrderVO;
import com.kedom.productService.entity.PmsOrder;
import com.kedom.productService.entity.PmsOrderItem;
import com.kedom.productService.service.PmsOrderService;
import com.kedom.productService.service.PmsSkuInfoService;
import com.kedom.productService.util.UUIDUtils;
import com.kedom.productService.vo.OrderSearchVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * (PmsOrder)表服务实现类
 *
 * @author makejava
 * @since 2023-04-11 14:11:35
 */
@Service("pmsOrderService")
public class PmsOrderServiceImpl implements PmsOrderService {
    @Resource
    private PmsOrderDao pmsOrderDao;

    @Resource
    private PmsOrderItemServiceImpl pmsOrderItemService;

    @Resource
    private PmsSkuInfoService pmsSkuInfoService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsOrder queryById(Long id) {
        PmsOrder obj = this.pmsOrderDao.queryById(id);
        return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsOrder 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsOrder pmsOrder) {
        int count = this.pmsOrderDao.insert(pmsOrder);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    /**
     * 修改数据
     *
     * @param pmsOrder 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsOrder pmsOrder) {
        int count = this.pmsOrderDao.update(pmsOrder);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public void createOrder(OrderVO pmsOrder) {
        PmsOrder pmsOrder1 = new PmsOrder();
        String SN = UUIDUtils.getId();
        BeanUtils.copyProperties(pmsOrder, pmsOrder1);
        pmsOrder1.setOrderSn(SN);
        pmsOrderDao.insert(pmsOrder1);

        List<PmsOrderItem> orderItem = pmsOrder.getOrderItem();
        orderItem.forEach(item -> {
            item.setOrderSn(SN);
        });

        pmsOrderItemService.batchAdd(orderItem);
        pmsSkuInfoService.createOrderAddSaleCountAndDeletWara(orderItem);


    }

    @Override
    public List<PmsOrder> queryByUserId(Long id, Integer offset, Integer limit) {

        return pmsOrderDao.queryByUserId(id, offset, limit);
    }

    @Override
    public List<OrderVO> queryAdmin(OrderSearchVO orderSearchVO) {

        if (orderSearchVO.getCreateTimeBegin() == null) {
            orderSearchVO.setCreateTimeBegin(LocalDate.parse("1970-01-01"));
        } else {
            orderSearchVO.setCreateTimeBegin(orderSearchVO.getCreateTimeBegin());
        }
        if (orderSearchVO.getCreateTimeEnd() == null) {
            orderSearchVO.setCreateTimeEnd(LocalDate.now());
        } else {
            orderSearchVO.setCreateTimeEnd(orderSearchVO.getCreateTimeEnd());
        }
        if (orderSearchVO.getPageNum() == null) {
            orderSearchVO.setPageNum(1);
        }
        orderSearchVO.setCreateTimeEnd(orderSearchVO.getCreateTimeEnd().plusDays(1));
        orderSearchVO.setPageNum((orderSearchVO.getPageNum() - 1) * 10);
        List<PmsOrder> ls = pmsOrderDao.queryAdmin(orderSearchVO);

        List<OrderVO> ls1 = new ArrayList<>();
        ls.forEach(item -> {
            OrderVO orderVO = new OrderVO();
            BeanUtils.copyProperties(item, orderVO);
            ls1.add(orderVO);
        });

        ls1.forEach(item -> {
            item.setOrderItem(pmsOrderItemService.queryByOrderSn(item.getOrderSn()));
        });

        return ls1;
    }

    @Override
    public Integer queryAdminTotal(OrderSearchVO orderSearchVO) {


        return pmsOrderDao.queryAdminTotal(orderSearchVO);
    }

    @Override
    public void cancelOrder(CancelOrderVO cancelOrderVO) {
        pmsOrderDao.cancelOrder(cancelOrderVO);

        pmsOrderItemService.cancelOrder(cancelOrderVO);
    }

}
