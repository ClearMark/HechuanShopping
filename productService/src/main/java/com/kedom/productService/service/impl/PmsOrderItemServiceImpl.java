package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsOrderItemDao;
import com.kedom.productService.entity.PmsOrderItem;
import com.kedom.productService.service.PmsOrderItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单项信息(PmsOrderItem)表服务实现类
 *
 * @author makejava
 * @since 2023-04-11 14:11:35
 */
@Service("pmsOrderItemService")
public class PmsOrderItemServiceImpl implements PmsOrderItemService {
    @Resource
    private PmsOrderItemDao pmsOrderItemDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsOrderItem queryById(Long id) {
        PmsOrderItem obj = this.pmsOrderItemDao.queryById(id);
        return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsOrderItem pmsOrderItem) {
        int count = this.pmsOrderItemDao.insert(pmsOrderItem);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    /**
     * 修改数据
     *
     * @param pmsOrderItem 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsOrderItem pmsOrderItem) {
        int count = this.pmsOrderItemDao.update(pmsOrderItem);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public void batchAdd(List<PmsOrderItem> orderItem) {
        pmsOrderItemDao.batchAdd(orderItem);
    }

    @Override
    public List<PmsOrderItem> queryByOrderId(String id) {
        return pmsOrderItemDao.queryByOrderId(id);
    }

}
