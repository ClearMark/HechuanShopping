package com.kedom.memberService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.memberService.dao.UmsShopDao;
import com.kedom.memberService.entity.ShopInfoVO;
import com.kedom.memberService.entity.UmsShop;
import com.kedom.memberService.service.UmsShopService;
import com.kedom.productService.entity.ShopSearchVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员(UmsShop)表服务实现类
 *
 * @author makejava
 * @since 2023-04-06 15:18:55
 */
@Service("umsShopService")
public class UmsShopServiceImpl implements UmsShopService {
    @Resource
    private UmsShopDao umsShopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsShop queryById(Long id) {
        UmsShop obj = this.umsShopDao.queryById(id);
        return obj;
    }

    /**
     * 新增数据
     *
     * @param umsShop 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(UmsShop umsShop) {
        int count = this.umsShopDao.insert(umsShop);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    /**
     * 修改数据
     *
     * @param umsShop 实例对象
     * @return 实例对象
     */
    @Override
    public void update(UmsShop umsShop) {
        int count = this.umsShopDao.update(umsShop);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public UmsShop queryByUserId(Long id) {

        return umsShopDao.queryByUserId(id);
    }

    @Override
    public ShopInfoVO getShopIndo(Long id) {

        return umsShopDao.getShopIndo(id);
    }

    @Override
    public List<ShopInfoVO> queryAll(ShopSearchVO umsShop) {
        umsShop.setPageNum((umsShop.getPageNum() - 1) * umsShop.getPageSize());
        return umsShopDao.queryAll(umsShop);
    }

    @Override
    public Integer queryAllTotal(ShopSearchVO umsShop) {
        return umsShopDao.queryAllTotal(umsShop);
    }

}
