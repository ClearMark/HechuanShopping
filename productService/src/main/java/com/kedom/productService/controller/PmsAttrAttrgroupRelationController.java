package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsAttrAttrgroupRelation;
import com.kedom.productService.service.PmsAttrAttrgroupRelationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 属性&属性分组关联(PmsAttrAttrgroupRelation)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:16
 */
@RestController
@RequestMapping("/pmsAttrAttrgroupRelation")
public class PmsAttrAttrgroupRelationController {
    /**
     * 服务对象
     */
    @Resource
    private PmsAttrAttrgroupRelationService pmsAttrAttrgroupRelationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsAttrAttrgroupRelationService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsAttrAttrgroupRelation 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
         this.pmsAttrAttrgroupRelationService.insert(pmsAttrAttrgroupRelation);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsAttrAttrgroupRelation 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsAttrAttrgroupRelation pmsAttrAttrgroupRelation) {
         this.pmsAttrAttrgroupRelationService.update(pmsAttrAttrgroupRelation);
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

