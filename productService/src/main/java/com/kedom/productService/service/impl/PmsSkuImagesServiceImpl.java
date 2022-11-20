package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.entity.PmsSkuImages;
import com.kedom.productService.dao.PmsSkuImagesDao;
import com.kedom.productService.service.PmsSkuImagesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

/**
 * sku图片(PmsSkuImages)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsSkuImagesService")
public class PmsSkuImagesServiceImpl implements PmsSkuImagesService {
    @Resource
    private PmsSkuImagesDao pmsSkuImagesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsSkuImages queryById(Long id) {
       PmsSkuImages obj=this.pmsSkuImagesDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsSkuImages 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsSkuImages pmsSkuImages) {
       int count= this.pmsSkuImagesDao.insert(pmsSkuImages);
       if(count==0)
       {
       throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsSkuImages 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsSkuImages pmsSkuImages) {
       int count= this.pmsSkuImagesDao.update(pmsSkuImages);
       if(count==0)
       {
        throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public void insertList(List<PmsSkuImages> skuImages) {
        int count= this.pmsSkuImagesDao.insertList(skuImages);
        if(count==0)
        {
            throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

}
