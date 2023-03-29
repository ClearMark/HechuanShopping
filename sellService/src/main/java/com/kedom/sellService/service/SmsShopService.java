package com.kedom.sellService.service;

import com.kedom.sellService.entity.SmsShop;

/**
 * 会员(SmsShop)表服务接口
 *
 * @author makejava
 * @since 2023-02-28 10:27:24
 */
public interface SmsShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmsShop queryById(Long id);

    /**
     * 新增数据
     *
     * @param smsShop 实例对象
     * @return 实例对象
     */
    void insert(SmsShop smsShop);

    /**
     * 修改数据
     *
     * @param smsShop 实例对象
     * @return 实例对象
     */
    void update(SmsShop smsShop);


    SmsShop queryByUsername(String username);
}
