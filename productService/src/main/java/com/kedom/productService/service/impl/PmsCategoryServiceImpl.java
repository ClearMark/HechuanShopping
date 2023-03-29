package com.kedom.productService.service.impl;


import com.kedom.common.entity.KedomUserException.KedomException;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.common.entity.productServiceEntity.PmsCategory;
import com.kedom.productService.dao.PmsCategoryDao;
import com.kedom.productService.entity.Page;
import com.kedom.productService.entity.PmsCategoryAfter;
import com.kedom.productService.entity.controllerVo.pmsCategory.CateAdePageVO;
import com.kedom.productService.service.PmsCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 商品三级分类(PmsCategory)表服务实现类
 *
 * @author makejava
 * @since 2022-11-02 21:10:05
 */
@Service("pmsCategoryService")
public class PmsCategoryServiceImpl implements PmsCategoryService {
    @Resource
    private PmsCategoryDao pmsCategoryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param catId 主键
     * @return 实例对象
     */
    @Override
    public PmsCategory queryById(Long catId) {
       this.pmsCategoryDao.queryById(catId);
     return null;
    }




    /**
     * 新增数据
     *
     * @param pmsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public void insert(PmsCategory pmsCategory) {
        int insert = this.pmsCategoryDao.insert(pmsCategory);
        if (insert == 0) {
            throw new KedomException(KedomExceptionEnum.INSERT_ERROR);
        }
    }

    /**
     * 修改数据
     *
     * @param pmsCategory 实例对象
     * @return 实例对象
     */
    @Override
    public Byte update(PmsCategory pmsCategory) {
        this.pmsCategoryDao.update(pmsCategory);
     return null;
    }

    /**
     * 通过主键删除数据
     *
     * @param catId 主键
     * @return 是否成功
     */
    @Override
    public Byte deleteById(Long catId) {
         this.pmsCategoryDao.deleteById(catId);
     return null;
    }

    @Override
    public List<PmsCategory> getAllProductCategory() {
        List<PmsCategory> allCategory = pmsCategoryDao.queryAll();
        List<PmsCategory> rootCategory = new ArrayList<>();

        Stream<PmsCategory> pmsCategoryStream = allCategory.stream().filter(pmsCategory -> pmsCategory.getParentCid() == 0);

        pmsCategoryStream.forEach(pmsCategory -> {
            pmsCategory.setChildren(getChildren(pmsCategory, allCategory));
            rootCategory.add(pmsCategory);
        });

        return rootCategory;
    }

    @Override
    public void removeCategoryById(List<Long> ids) {
        //TODO 判断是否被商品引用

        //删除当前菜单及其子菜单
        pmsCategoryDao.deleteCategorysById(ids);
    }

    @Override
    public void checkCategoryIsThereLevelCategory(Long cateId) {
        int count= this.pmsCategoryDao.checkCategoryIsThreeLevelCategory(cateId);
        if(count!=1)
        {
            throw new KedomException(KedomExceptionEnum.CategoryNotIsThereLevelCateGory);
        }
    }

    @Override
    public List<PmsCategory> getProductCategory(CateAdePageVO cateAdePageVO) {

        Page page = cateAdePageVO.getPage();
        page.setPageBegin((page.getPageNum() - 1) * page.getPageSize());
        List<PmsCategory> productCategoryPage = pmsCategoryDao.getProductCategoryPage(cateAdePageVO.getPage(), cateAdePageVO.getPmsCategory());
        return productCategoryPage;

    }

    @Override
    public Integer getProductCategoryCount(PmsCategory pmsCategory) {
       return pmsCategoryDao.getProductCategoryCount(pmsCategory);
    }

    @Override
    public List<PmsCategoryAfter> getAllProductCategoryCase() {
        return null;
    }


    private ArrayList<PmsCategory> getChildren(PmsCategory pmsCategory, List<PmsCategory> pmsCategories) {
        ArrayList<PmsCategory> children = new ArrayList<>();
        pmsCategories.stream().filter(pmsCategory1 -> pmsCategory.getCatId().equals(pmsCategory1.getParentCid())).forEach(pmsCategory1 -> {
            pmsCategory1.setChildren(getChildren(pmsCategory1, pmsCategories));
            children.add(pmsCategory1);
        });
        return children;
    }
}
