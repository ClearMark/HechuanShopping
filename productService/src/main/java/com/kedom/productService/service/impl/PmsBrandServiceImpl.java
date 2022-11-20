package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.common.entity.productServiceEntity.PmsBrand;
import com.kedom.productService.dao.PmsBrandDao;
import com.kedom.productService.service.PmsBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 品牌(PmsBrand)表服务实现类
 *
 * @author makejava
 * @since 2022-11-03 00:38:07
 */
@Service("pmsBrandService")
public class PmsBrandServiceImpl implements PmsBrandService {
    @Resource
    private PmsBrandDao pmsBrandDao;

    /**
     * 通过ID查询单条数据
     *
     * @param brandId 主键
     * @return 实例对象
     */
    @Override
    public PmsBrand queryById(Long brandId) {
       PmsBrand obj=this.pmsBrandDao.queryById(brandId);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsBrand 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsBrand pmsBrand) {
       int count= this.pmsBrandDao.insert(pmsBrand);
       if(count==0)
       {
       throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsBrand 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsBrand pmsBrand) {
       int count= this.pmsBrandDao.update(pmsBrand);
       if(count==0)
       {
        throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

}
