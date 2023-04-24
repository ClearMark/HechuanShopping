package com.kedom.productService.service;

import com.kedom.productService.entity.CancelOrderVO;
import com.kedom.productService.entity.OrderItemVO;
import com.kedom.productService.entity.PmsOrderItem;

import java.util.List;

/**
 * 订单项信息(PmsOrderItem)表服务接口
 *
 * @author makejava
 * @since 2023-04-11 14:11:35
 */
public interface PmsOrderItemService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsOrderItem queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsOrderItem 实例对象
     * @return 实例对象
     */
    void insert(PmsOrderItem pmsOrderItem);

    /**
     * 修改数据
     *
     * @param pmsOrderItem 实例对象
     * @return 实例对象
     */
    void update(PmsOrderItem pmsOrderItem);


    void batchAdd(List<PmsOrderItem> orderItem);

    List<PmsOrderItem> queryByOrderId(String id);

    List<OrderItemVO> queryOrderItemByUserId(String userId, Integer offset, Integer limit);

    List<PmsOrderItem> queryByOrderSn(String orderSn);

    void cancelOrder(CancelOrderVO cancelOrderVO);

    Integer queryOrderItemByUserIdTotal(String userId);

    void ok(CancelOrderVO cancelOrderVO);

    void cancel(CancelOrderVO cancelOrderVO);
}
