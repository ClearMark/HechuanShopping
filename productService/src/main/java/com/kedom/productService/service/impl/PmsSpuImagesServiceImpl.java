package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.entity.PmsSpuImages;
import com.kedom.productService.dao.PmsSpuImagesDao;
import com.kedom.productService.service.PmsSpuImagesService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;

/**
 * spu图片(PmsSpuImages)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsSpuImagesService")
public class PmsSpuImagesServiceImpl implements PmsSpuImagesService {
    @Resource
    private PmsSpuImagesDao pmsSpuImagesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsSpuImages queryById(Long id) {
       PmsSpuImages obj=this.pmsSpuImagesDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsSpuImages 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsSpuImages pmsSpuImages) {
       int count= this.pmsSpuImagesDao.insert(pmsSpuImages);
       if(count==0)
       {
       throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsSpuImages 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsSpuImages pmsSpuImages) {
       int count= this.pmsSpuImagesDao.update(pmsSpuImages);
       if(count==0)
       {
        throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public void insertList(List<PmsSpuImages> images) {
        int count= this.pmsSpuImagesDao.insertList(images);
        if(count==0)
        {
            throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

}
