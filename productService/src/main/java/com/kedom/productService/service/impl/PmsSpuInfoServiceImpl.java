package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomUserException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsSpuInfoDao;
import com.kedom.productService.entity.PmsSpuInfo;
import com.kedom.productService.service.PmsSpuInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * spu信息(PmsSpuInfo)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Service("pmsSpuInfoService")
public class PmsSpuInfoServiceImpl implements PmsSpuInfoService {
    @Resource
    private PmsSpuInfoDao pmsSpuInfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsSpuInfo queryById(Long id) {
       PmsSpuInfo obj=this.pmsSpuInfoDao.queryById(id);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsSpuInfo 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsSpuInfo pmsSpuInfo) {
       int count= this.pmsSpuInfoDao.insert(pmsSpuInfo);
       if(count==0)
       {
       throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsSpuInfo 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsSpuInfo pmsSpuInfo) {
       int count= this.pmsSpuInfoDao.update(pmsSpuInfo);
       if(count==0)
       {
        throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    @Override
    public void insertGetKey(PmsSpuInfo pmsSpuInfo) {
        int count = this.pmsSpuInfoDao.insertGetKey(pmsSpuInfo);
        if (count == 0) {
            throw new KedomUserException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    @Override
    public void spuPutOnShelves(Long id) {

        int count = this.pmsSpuInfoDao.spuPutOnShelves(id);
        if (count == 0) {
            throw new KedomUserException(KedomExceptionEnum.PUT_ON_SHELVES_ERROR);
        }
    }

}
