package com.kedom.memberService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.memberService.entity.UmsMemberReceiveAddress;
import com.kedom.memberService.dao.UmsMemberReceiveAddressDao;
import com.kedom.memberService.service.UmsMemberReceiveAddressService;
import org.springframework.stereotype.Service;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员收货地址(UmsMemberReceiveAddress)表服务实现类
 *
 * @author makejava
 * @since 2023-03-17 22:36:27
 */
@Service("umsMemberReceiveAddressService")
public class UmsMemberReceiveAddressServiceImpl implements UmsMemberReceiveAddressService {
    @Resource
    private UmsMemberReceiveAddressDao umsMemberReceiveAddressDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsMemberReceiveAddress queryById(Long id) {
       UmsMemberReceiveAddress obj=this.umsMemberReceiveAddressDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param umsMemberReceiveAddress 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(UmsMemberReceiveAddress umsMemberReceiveAddress) {
       int count= this.umsMemberReceiveAddressDao.insert(umsMemberReceiveAddress);
       if(count==0)
       {
       throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param umsMemberReceiveAddress 实例对象
     * @return 实例对象
     */
    @Override
    public void update(UmsMemberReceiveAddress umsMemberReceiveAddress) {
       int count= this.umsMemberReceiveAddressDao.update(umsMemberReceiveAddress);
       if(count==0)
       {
        throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public void delete(Long id) {
        int i = this.umsMemberReceiveAddressDao.deleteById(id);
        if(i==0)
        {
            throw new KedomException(KedomExceptionEnum.DELETE_ERROR);
        }
    }

    @Override
    public List<UmsMemberReceiveAddress> queryMemberById(Long id) {

        return this.umsMemberReceiveAddressDao.queryMemberById(id);
    }

}
