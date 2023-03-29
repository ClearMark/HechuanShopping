package com.kedom.memberService.service;

import com.kedom.memberService.entity.UmsMemberReceiveAddress;

import java.util.List;

/**
 * 会员收货地址(UmsMemberReceiveAddress)表服务接口
 *
 * @author makejava
 * @since 2023-03-17 22:36:27
 */
public interface UmsMemberReceiveAddressService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsMemberReceiveAddress queryById(Long id);

    /**
     * 新增数据
     *
     * @param umsMemberReceiveAddress 实例对象
     * @return 实例对象
     */
    void insert(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 修改数据
     *
     * @param umsMemberReceiveAddress 实例对象
     * @return 实例对象
     */
    void update(UmsMemberReceiveAddress umsMemberReceiveAddress);


    void delete(Long id);

    List<UmsMemberReceiveAddress> queryMemberById(Long id);
}
