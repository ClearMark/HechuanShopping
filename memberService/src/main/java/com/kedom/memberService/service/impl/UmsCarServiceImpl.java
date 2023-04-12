package com.kedom.memberService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.memberService.dao.UmsCarDao;
import com.kedom.memberService.entity.UmsCar;
import com.kedom.memberService.service.UmsCarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UmsCar)表服务实现类
 *
 * @author makejava
 * @since 2023-04-06 14:21:32
 */
@Service("umsCarService")
public class UmsCarServiceImpl implements UmsCarService {
    @Resource
    private UmsCarDao umsCarDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsCar queryById(Integer id) {
        UmsCar obj = this.umsCarDao.queryById(id);
        return obj;
    }

    /**
     * 新增数据
     *
     * @param umsCar 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(UmsCar umsCar) {
        int count = this.umsCarDao.insert(umsCar);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    /**
     * 修改数据
     *
     * @param umsCar 实例对象
     * @return 实例对象
     */
    @Override
    public void update(UmsCar umsCar) {
        int count = this.umsCarDao.update(umsCar);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public List<UmsCar> queryByUserId(Integer id, Integer offset, Integer limit) {

        return this.umsCarDao.queryByUserId(id, offset, limit);
    }

    @Override
    public void deleteById(Integer id) {
        umsCarDao.deleteById(id);
    }

    @Override
    public void orderOK(List<Integer> orderOK) {
        umsCarDao.orderOK(orderOK);
    }

}
