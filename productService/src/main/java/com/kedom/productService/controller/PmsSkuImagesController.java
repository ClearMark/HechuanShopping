package com.kedom.productService.controller;

import com.kedom.productService.entity.PmsSkuImages;
import com.kedom.productService.service.PmsSkuImagesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kedom.common.entity.KedomResponse;

import javax.annotation.Resource;

/**
 * sku图片(PmsSkuImages)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/pmsSkuImages")
public class PmsSkuImagesController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSkuImagesService pmsSkuImagesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsSkuImagesService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsSkuImages 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsSkuImages pmsSkuImages) {
         this.pmsSkuImagesService.insert(pmsSkuImages);
     return KedomResponse.OK();
    }

    /**
     * 编辑数据
     *
     * @param pmsSkuImages 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsSkuImages pmsSkuImages) {
         this.pmsSkuImagesService.update(pmsSkuImages);
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

