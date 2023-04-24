package com.kedom.memberService.service;

import com.kedom.memberService.entity.AdminEditPasswordDTO;
import com.kedom.memberService.entity.UmsAdmin;

/**
 * (UmsAdmin)表服务接口
 *
 * @author makejava
 * @since 2023-04-16 21:03:33
 */
public interface UmsAdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdmin queryById(Integer id);

    /**
     * 新增数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    void insert(UmsAdmin umsAdmin);

    /**
     * 修改数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    void update(UmsAdmin umsAdmin);


    Integer login(UmsAdmin umsAdmin);

    String editPassword(AdminEditPasswordDTO umsAdmin);
}
