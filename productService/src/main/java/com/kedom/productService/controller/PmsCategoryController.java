package com.kedom.productService.controller;


import com.alibaba.fastjson.JSON;
import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.productServiceEntity.PmsCategory;
import com.kedom.productService.entity.PmsCategoryAfter;
import com.kedom.productService.entity.controllerVo.pmsCategory.CateAdePageVO;
import com.kedom.productService.service.PmsCategoryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 商品三级分类(PmsCategory)表控制层
 *
 * @author makejava
 * @since 2022-11-02 21:10:01
 */
@RestController
@RequestMapping("/productService/pmsCategory")
public class PmsCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private PmsCategoryService pmsCategoryService;

    @GetMapping
    public KedomResponse getAllProductCategory() {
        List<PmsCategory> allProductCategory = pmsCategoryService.getAllProductCategory();
        return KedomResponse.okAddData(allProductCategory);
    }

    @GetMapping("/case")
    public KedomResponse getAllProductCategoryCase() {
        List<PmsCategory> allProductCategory = pmsCategoryService.getAllProductCategory();
        List<PmsCategoryAfter> pmsCategoryAfters = new ArrayList<>();
        for (PmsCategory pmsCategory : allProductCategory) {
            PmsCategoryAfter pmsCategoryAfter = new PmsCategoryAfter();
            pmsCategoryAfter.setValue(pmsCategory.getCatId().toString());
            pmsCategoryAfter.setLabel(pmsCategory.getName());
            pmsCategoryAfter.setChildren(setChildren(pmsCategory));
            pmsCategoryAfters.add(pmsCategoryAfter);
        }

        return KedomResponse.okAddData(JSON.toJSON(pmsCategoryAfters));
    }

    public ArrayList<PmsCategoryAfter> setChildren(PmsCategory pmsCategory) {
        ArrayList<PmsCategoryAfter> pmsCategoryAfters = new ArrayList<>();
        for (PmsCategory pmsCategory1 : pmsCategory.getChildren()) {
            PmsCategoryAfter pmsCategoryAfter = new PmsCategoryAfter();
            pmsCategoryAfter.setValue(pmsCategory1.getCatId().toString());
            pmsCategoryAfter.setLabel(pmsCategory1.getName());
            pmsCategoryAfter.setChildren(setChildren(pmsCategory1));
            pmsCategoryAfters.add(pmsCategoryAfter);
        }
        return pmsCategoryAfters.size()==0?null:pmsCategoryAfters;
    }





    @PostMapping("/getProductCategoryAndPage")
    public KedomResponse getProductCategoryAndPage(@RequestBody CateAdePageVO cateAdePageVO) {

        List<PmsCategory> productCategorys = pmsCategoryService.getProductCategory(cateAdePageVO);

        KedomResponse kedomResponse = KedomResponse.okAddData(productCategorys);

        Integer productCategoryCount = pmsCategoryService.getProductCategoryCount(cateAdePageVO.getPmsCategory());


        kedomResponse.setTotal(productCategoryCount);

        return kedomResponse;
    }


    //前端请求方式[1,2,3] 直接写一个数组就完了
    @PostMapping("/removeCategoryById")
    public KedomResponse removeCategoryById(@RequestBody ArrayList<Long> ids) {
        pmsCategoryService.removeCategoryById(ids);
        return KedomResponse.ok();
    }

    @PostMapping
    public KedomResponse addCategory(@RequestBody PmsCategory pmsCategory) {
        pmsCategoryService.insert(pmsCategory);
        return KedomResponse.ok();
    }


}

