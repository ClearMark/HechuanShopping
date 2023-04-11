package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsRecommendProduct;
import com.kedom.productService.service.PmsRecommendProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (PmsRecommendProduct)表控制层
 *
 * @author makejava
 * @since 2023-04-10 14:07:40
 */
@RestController
@RequestMapping("/productService/pmsRecommendProduct")
public class PmsRecommendProductController {
    /**
     * 服务对象
     */
    @Resource
    private PmsRecommendProductService pmsRecommendProductService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Integer id) {
        ResponseEntity.ok(this.pmsRecommendProductService.queryById(id));
        return null;
    }

    /**
     * 新增数据
     *
     * @param pmsRecommendProduct 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public KedomResponse add(@RequestBody PmsRecommendProduct pmsRecommendProduct) {
        this.pmsRecommendProductService.insert(pmsRecommendProduct);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsRecommendProduct 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsRecommendProduct pmsRecommendProduct) {
        this.pmsRecommendProductService.update(pmsRecommendProduct);
        return KedomResponse.ok();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public KedomResponse deleteById(Integer id) {
        return null;
    }

}

