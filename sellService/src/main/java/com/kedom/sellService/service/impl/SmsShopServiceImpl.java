package com.kedom.sellService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.sellService.dao.SmsShopDao;
import com.kedom.sellService.entity.SmsShop;
import com.kedom.sellService.service.SmsShopService;
import org.springframework.stereotype.Service;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;

import javax.annotation.Resource;

/**
 * 会员(SmsShop)表服务实现类
 *
 * @author makejava
 * @since 2023-02-28 10:27:25
 */
@Service("smsShopService")
public class SmsShopServiceImpl implements SmsShopService {
    @Resource
    private SmsShopDao smsShopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SmsShop queryById(Long id) {
       SmsShop obj=this.smsShopDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param smsShop 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(SmsShop smsShop) {
       int count= this.smsShopDao.insert(smsShop);
       if(count==0)
       {
       throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param smsShop 实例对象
     * @return 实例对象
     */
    @Override
    public void update(SmsShop smsShop) {
       int count= this.smsShopDao.update(smsShop);
       if(count==0)
       {
        throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public SmsShop queryByUsername(String username) {
       SmsShop smsShop=smsShopDao.queryByUsername(username);
       if (smsShop==null)
       {
           throw new KedomException(KedomExceptionEnum.SHOP_NO_HAVE);
       }
       return smsShop;
    }

}
