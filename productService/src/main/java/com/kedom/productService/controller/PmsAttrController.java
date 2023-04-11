package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsAttr;
import com.kedom.productService.entity.vo.CategoryAttrVO;
import com.kedom.productService.service.PmsAttrService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品属性(PmsAttr)表控制层
 *
 * @author makejava
 * @since 2022-11-04 10:51:14
 */
@RestController
@RequestMapping("/productService/pmsAttr")
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
        List<PmsAttr> pmsAttr = this.pmsAttrService.queryById(id);
        return KedomResponse.okAddData(pmsAttr);
    }
    @GetMapping("/page/{num}")
    public KedomResponse queryAllAttr(@PathVariable("num") Integer num) {
        List<CategoryAttrVO> pmsAttr = this.pmsAttrService.queryAllAttr(num);
        return KedomResponse.okAddData(pmsAttr);
    }

    @GetMapping("/getCategoryAttr/{id}")
    public KedomResponse getCategoryAttr(@PathVariable("id") Long id) {
       List<CategoryAttrVO> pmsAttr = this.pmsAttrService.queryAllAttrNameByCateId(id);
        return KedomResponse.okAddData(pmsAttr);
    }

    @GetMapping("/getCategorySearchAttr/{id}")
    public KedomResponse getCategorySearchAttr(@PathVariable("id") Long id) {
       List<PmsAttr> pmsAttrList=pmsAttrService.getCategorySearchAttr(id);
        return KedomResponse.okAddData(pmsAttrList);
    }


    /**
     * 新增数据
     *
     * @param pmsAttr 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(@RequestBody PmsAttr pmsAttr) {
         this.pmsAttrService.insert(pmsAttr);
        return KedomResponse.ok();
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
        return KedomResponse.ok();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{id}")
    public KedomResponse deleteById(@PathVariable("id") Long id) {
        this.pmsAttrService.deleteAttrById(id);
        return KedomResponse.ok();
    }

}

