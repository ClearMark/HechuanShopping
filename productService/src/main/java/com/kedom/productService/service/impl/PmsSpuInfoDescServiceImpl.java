package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsSpuInfoDescDao;
import com.kedom.productService.entity.PmsSpuInfoDesc;
import com.kedom.productService.service.PmsSpuInfoDescService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * spu信息介绍(PmsSpuInfoDesc)表服务实现类
 *
 * @author makejava
 * @since 2022-11-17 14:25:39
 */
@Service("pmsSpuInfoDescService")
public class PmsSpuInfoDescServiceImpl implements PmsSpuInfoDescService {
    @Resource
    private PmsSpuInfoDescDao pmsSpuInfoDescDao;

    /**
     * 通过ID查询单条数据
     *
     * @param spuId 主键
     * @return 实例对象
     */
    @Override
    public PmsSpuInfoDesc queryById(Long spuId) {
       PmsSpuInfoDesc obj=this.pmsSpuInfoDescDao.queryById(spuId);
     return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsSpuInfoDesc 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsSpuInfoDesc pmsSpuInfoDesc) {
       int count= this.pmsSpuInfoDescDao.insert(pmsSpuInfoDesc);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

    /**
     * 修改数据
     *
     * @param pmsSpuInfoDesc 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsSpuInfoDesc pmsSpuInfoDesc) {
       int count= this.pmsSpuInfoDescDao.update(pmsSpuInfoDesc);
       if(count==0)
       {
           throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
       }
    }

}
