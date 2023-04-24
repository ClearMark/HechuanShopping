package com.kedom.memberService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.memberService.dao.UmsAdminDao;
import com.kedom.memberService.entity.AdminEditPasswordDTO;
import com.kedom.memberService.entity.UmsAdmin;
import com.kedom.memberService.service.UmsAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (UmsAdmin)表服务实现类
 *
 * @author makejava
 * @since 2023-04-16 21:03:33
 */
@Service("umsAdminService")
public class UmsAdminServiceImpl implements UmsAdminService {
    @Resource
    private UmsAdminDao umsAdminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsAdmin queryById(Integer id) {
        UmsAdmin obj = this.umsAdminDao.queryById(id);
        return obj;
    }

    /**
     * 新增数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(UmsAdmin umsAdmin) {
        int count = this.umsAdminDao.insert(umsAdmin);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    /**
     * 修改数据
     *
     * @param umsAdmin 实例对象
     * @return 实例对象
     */
    @Override
    public void update(UmsAdmin umsAdmin) {
        int count = this.umsAdminDao.update(umsAdmin);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public Integer login(UmsAdmin umsAdmin) {
        Integer integer = umsAdminDao.login(umsAdmin);
        if (integer == null || integer == 0) {
            throw new KedomException(KedomExceptionEnum.USERNAME_OR_PASSWORD_ERROR);
        }
        return integer;

    }

    @Override
    public String editPassword(AdminEditPasswordDTO umsAdmin) {
        Integer integer = umsAdminDao.editPassword(umsAdmin);
        if (integer == null || integer == 0) {
            return "原密码错误";
        }
        return "修改成功";
    }

}
