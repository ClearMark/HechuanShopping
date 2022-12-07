package com.kedom.productService.controller;


import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.productServiceEntity.PmsBrand;
import com.kedom.productService.service.PmsBrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 品牌(PmsBrand)表控制层
 *
 * @author makejava
 * @since 2022-11-03 00:38:07
 */
@RestController
@RequestMapping("/pmsBrand")
public class PmsBrandController {
    /**
     * 服务对象
     */
    @Resource
    private PmsBrandService pmsBrandService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsBrandService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsBrand 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsBrand pmsBrand) {
         this.pmsBrandService.insert(pmsBrand);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsBrand 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsBrand pmsBrand) {
         this.pmsBrandService.update(pmsBrand);
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

