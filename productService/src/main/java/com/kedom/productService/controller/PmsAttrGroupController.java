package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsAttrGroup;
import com.kedom.productService.service.PmsAttrGroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 属性分组(PmsAttrGroup)表控制层
 *
 * @author makejava
 * @since 2022-11-03 18:34:54
 */
@RestController
@RequestMapping("/pmsAttrGroup")
public class PmsAttrGroupController {
    /**
     * 服务对象
     */
    @Resource
    private PmsAttrGroupService pmsAttrGroupService;

    /**
     * 通过主键查询单条数据
     *

     * @return 单条数据
     */
    @GetMapping("/{cateGoryId}")
    public KedomResponse queryAttrGroupByCateGoryId(@RequestParam HashMap<String,Object> paramMap, @PathVariable("cateGoryId") Long cateGoryId) {
        ArrayList<PmsAttrGroup> pmsAttrGroups = this.pmsAttrGroupService.queryAttrGroupByCateGoryId(paramMap,cateGoryId);
        return null;
    }

    /**
     * 新增数据
     *
     * @param pmsAttrGroup 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsAttrGroup pmsAttrGroup) {
         this.pmsAttrGroupService.insert(pmsAttrGroup);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsAttrGroup 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsAttrGroup pmsAttrGroup) {
         this.pmsAttrGroupService.update(pmsAttrGroup);
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

