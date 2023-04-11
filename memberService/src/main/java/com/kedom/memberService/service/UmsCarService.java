package com.kedom.memberService.service;

import com.kedom.memberService.entity.UmsCar;

import java.util.List;

/**
 * (UmsCar)表服务接口
 *
 * @author makejava
 * @since 2023-04-06 14:21:32
 */
public interface UmsCarService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsCar queryById(Integer id);

    /**
     * 新增数据
     *
     * @param umsCar 实例对象
     * @return 实例对象
     */
    void insert(UmsCar umsCar);

    /**
     * 修改数据
     *
     * @param umsCar 实例对象
     * @return 实例对象
     */
    void update(UmsCar umsCar);


    List<UmsCar> queryByUserId(Integer id, Integer offset, Integer limit);

    void deleteById(Integer id);
}
