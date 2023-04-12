package com.kedom.productService.service;

import com.kedom.productService.entity.OrderVO;
import com.kedom.productService.entity.PmsOrder;

import java.util.List;

/**
 * (PmsOrder)表服务接口
 *
 * @author makejava
 * @since 2023-04-11 14:11:34
 */
public interface PmsOrderService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsOrder queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsOrder 实例对象
     * @return 实例对象
     */
    void insert(PmsOrder pmsOrder);

    /**
     * 修改数据
     *
     * @param pmsOrder 实例对象
     * @return 实例对象
     */
    void update(PmsOrder pmsOrder);


    void createOrder(OrderVO pmsOrder);

    List<PmsOrder> queryByUserId(Long id, Integer offset, Integer limit);
}
