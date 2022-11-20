package com.kedom.productService.controller;

import com.kedom.productService.entity.PmsAttr;
import com.kedom.productService.service.PmsAttrService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kedom.common.entity.KedomResponse;

import javax.annotation.Resource;

/**
 * 商品属性(PmsAttr)表控制层
 *
 * @author makejava
 * @since 2022-11-04 10:51:14
 */
@RestController
@RequestMapping("/pmsAttr")
public class PmsAttrController {
    /**
     * 服务对象
     */
    @Resource
    private PmsAttrService pmsAttrService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsAttrService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsAttr 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsAttr pmsAttr) {
         this.pmsAttrService.insert(pmsAttr);
     return KedomResponse.OK();
    }

    /**
     * 编辑数据
     *
     * @param pmsAttr 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsAttr pmsAttr) {
         this.pmsAttrService.update(pmsAttr);
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

