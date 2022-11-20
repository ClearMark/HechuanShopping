package com.kedom.productService.controller;

import com.kedom.productService.entity.PmsSkuSaleAttrValue;
import com.kedom.productService.service.PmsSkuSaleAttrValueService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kedom.common.entity.KedomResponse;

import javax.annotation.Resource;

/**
 * sku销售属性&值(PmsSkuSaleAttrValue)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/pmsSkuSaleAttrValue")
public class PmsSkuSaleAttrValueController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSkuSaleAttrValueService pmsSkuSaleAttrValueService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsSkuSaleAttrValueService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsSkuSaleAttrValue 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsSkuSaleAttrValue pmsSkuSaleAttrValue) {
         this.pmsSkuSaleAttrValueService.insert(pmsSkuSaleAttrValue);
     return KedomResponse.OK();
    }

    /**
     * 编辑数据
     *
     * @param pmsSkuSaleAttrValue 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsSkuSaleAttrValue pmsSkuSaleAttrValue) {
         this.pmsSkuSaleAttrValueService.update(pmsSkuSaleAttrValue);
     return KedomResponse.OK();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public KedomResponse deleteById(Long id) {
     return null;
    }

}

