package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsSpuInfo;
import com.kedom.productService.service.PmsSpuInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * spu信息(PmsSpuInfo)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/pmsSpuInfo")
public class PmsSpuInfoController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSpuInfoService pmsSpuInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsSpuInfoService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsSpuInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsSpuInfo pmsSpuInfo) {
         this.pmsSpuInfoService.insert(pmsSpuInfo);
     return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsSpuInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsSpuInfo pmsSpuInfo) {
        this.pmsSpuInfoService.update(pmsSpuInfo);
        return KedomResponse.ok();
    }

    @PutMapping("/putOnShelves/{id}")
    public KedomResponse spuPutOnShelves(@PathVariable("id") Long id) {
        this.pmsSpuInfoService.spuPutOnShelves(id);
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

