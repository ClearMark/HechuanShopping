package com.kedom.productService.controller;

import com.kedom.productService.entity.PmsCategoryBrandRelation;
import com.kedom.productService.service.PmsCategoryBrandRelationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kedom.common.entity.KedomResponse;

import javax.annotation.Resource;

/**
 * 品牌分类关联(PmsCategoryBrandRelation)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/pmsCategoryBrandRelation")
public class PmsCategoryBrandRelationController {
    /**
     * 服务对象
     */
    @Resource
    private PmsCategoryBrandRelationService pmsCategoryBrandRelationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsCategoryBrandRelationService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsCategoryBrandRelation 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsCategoryBrandRelation pmsCategoryBrandRelation) {
         this.pmsCategoryBrandRelationService.insert(pmsCategoryBrandRelation);
     return KedomResponse.OK();
    }

    /**
     * 编辑数据
     *
     * @param pmsCategoryBrandRelation 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsCategoryBrandRelation pmsCategoryBrandRelation) {
         this.pmsCategoryBrandRelationService.update(pmsCategoryBrandRelation);
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

