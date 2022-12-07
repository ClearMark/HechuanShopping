package com.kedom.productService.controller;


import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.productServiceEntity.PmsCategory;
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
@RequestMapping("/pmsCategory")
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

    //前端请求方式[1,2,3] 直接写一个数组就完了
    @DeleteMapping
    public KedomResponse removeCategoryById(@RequestBody ArrayList<Long> ids) {
       pmsCategoryService.removeCategoryById(ids);
        return KedomResponse.ok();
    }

    @PostMapping
    public KedomResponse addCategory(PmsCategory pmsCategory) {
        pmsCategoryService.insert(pmsCategory);
        return KedomResponse.ok();
    }


}

