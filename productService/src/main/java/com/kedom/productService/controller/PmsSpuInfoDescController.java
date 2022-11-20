package com.kedom.productService.controller;

import com.kedom.productService.entity.PmsSpuInfoDesc;
import com.kedom.productService.service.PmsSpuInfoDescService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kedom.common.entity.KedomResponse;

import javax.annotation.Resource;

/**
 * spu信息介绍(PmsSpuInfoDesc)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/pmsSpuInfoDesc")
public class PmsSpuInfoDescController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSpuInfoDescService pmsSpuInfoDescService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsSpuInfoDescService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsSpuInfoDesc 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsSpuInfoDesc pmsSpuInfoDesc) {
         this.pmsSpuInfoDescService.insert(pmsSpuInfoDesc);
     return KedomResponse.OK();
    }

    /**
     * 编辑数据
     *
     * @param pmsSpuInfoDesc 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsSpuInfoDesc pmsSpuInfoDesc) {
         this.pmsSpuInfoDescService.update(pmsSpuInfoDesc);
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

