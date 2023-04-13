package com.kedom.memberService.service;

import com.kedom.memberService.entity.UmsShopNotCheck;

import java.util.List;

/**
 * (UmsShopNotCheck)表服务接口
 *
 * @author makejava
 * @since 2023-04-07 18:04:59
 */
public interface UmsShopNotCheckService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsShopNotCheck queryById(Integer id);

    /**
     * 新增数据
     *
     * @param umsShopNotCheck 实例对象
     * @return 实例对象
     */
    void insert(UmsShopNotCheck umsShopNotCheck);

    /**
     * 修改数据
     *
     * @param umsShopNotCheck 实例对象
     * @return 实例对象
     */
    void update(UmsShopNotCheck umsShopNotCheck);


    List allNotCheck();

    void checkShop(UmsShopNotCheck umsShopNotCheck);

    UmsShopNotCheck userShop(Long id);

    UmsShopNotCheck deleteShopCheck(Long id);
}
