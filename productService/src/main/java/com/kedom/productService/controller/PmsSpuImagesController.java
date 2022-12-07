package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsSpuImages;
import com.kedom.productService.service.PmsSpuImagesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * spu图片(PmsSpuImages)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/pmsSpuImages")
public class PmsSpuImagesController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSpuImagesService pmsSpuImagesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsSpuImagesService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsSpuImages 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsSpuImages pmsSpuImages) {
         this.pmsSpuImagesService.insert(pmsSpuImages);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsSpuImages 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsSpuImages pmsSpuImages) {
         this.pmsSpuImagesService.update(pmsSpuImages);
        return KedomResponse.ok();
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

