package com.kedom.memberService.service;

import com.kedom.memberService.entity.UmsShop;

/**
 * 会员(UmsShop)表服务接口
 *
 * @author makejava
 * @since 2023-04-06 15:18:55
 */
public interface UmsShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsShop queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsShop 实例对象
     * @return 实例对象
     */
    void insert(UmsShop umsShop);

    /**
     * 修改数据
     *
     * @param umsShop 实例对象
     * @return 实例对象
     */
    void update(UmsShop umsShop);


    UmsShop queryByUserId(Long id);
}
