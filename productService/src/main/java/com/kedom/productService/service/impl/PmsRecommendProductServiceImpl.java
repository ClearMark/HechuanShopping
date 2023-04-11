package com.kedom.productService.service.impl;

import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.dao.PmsRecommendProductDao;
import com.kedom.productService.entity.PmsRecommendProduct;
import com.kedom.productService.service.PmsRecommendProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (PmsRecommendProduct)表服务实现类
 *
 * @author makejava
 * @since 2023-04-10 14:07:40
 */
@Service("pmsRecommendProductService")
public class PmsRecommendProductServiceImpl implements PmsRecommendProductService {
    @Resource
    private PmsRecommendProductDao pmsRecommendProductDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public PmsRecommendProduct queryById(Integer id) {
        PmsRecommendProduct obj = this.pmsRecommendProductDao.queryById(id);
        return obj;
    }

    /**
     * 新增数据
     *
     * @param pmsRecommendProduct 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsRecommendProduct pmsRecommendProduct) {
        int count = this.pmsRecommendProductDao.insert(pmsRecommendProduct);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    /**
     * 修改数据
     *
     * @param pmsRecommendProduct 实例对象
     * @return 实例对象
     */
    @Override
    public void update(PmsRecommendProduct pmsRecommendProduct) {
        int count = this.pmsRecommendProductDao.update(pmsRecommendProduct);
        if (count == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

}
