package com.kedom.memberService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.memberService.dao.UmsShopNotCheckDao;
import com.kedom.memberService.entity.UmsShopNotCheck;
import com.kedom.memberService.service.UmsShopNotCheckService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UmsShopNotCheck)表服务实现类
 *
 * @author makejava
 * @since 2023-04-07 18:04:59
 */
@Service("umsShopNotCheckService")
public class UmsShopNotCheckServiceImpl implements UmsShopNotCheckService {
    @Resource
    private UmsShopNotCheckDao umsShopNotCheckDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsShopNotCheck queryById(Integer id) {
        UmsShopNotCheck obj = this.umsShopNotCheckDao.queryById(id);
        return obj;
    }

    /**
     * 新增数据
     *
     * @param umsShopNotCheck 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(UmsShopNotCheck umsShopNotCheck) {
        int count = this.umsShopNotCheckDao.insert(umsShopNotCheck);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    /**
     * 修改数据
     *
     * @param umsShopNotCheck 实例对象
     * @return 实例对象
     */
    @Override
    public void update(UmsShopNotCheck umsShopNotCheck) {
        int count = this.umsShopNotCheckDao.update(umsShopNotCheck);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public List allNotCheck() {

        List<UmsShopNotCheck> list = umsShopNotCheckDao.allNotCheck();
        return list;
    }

}
