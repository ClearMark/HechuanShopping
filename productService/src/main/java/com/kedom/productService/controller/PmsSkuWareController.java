package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.common.entity.exceptionEnum.KedomExceptionEnum;
import com.kedom.productService.entity.PmsSkuWare;
import com.kedom.productService.service.PmsSkuWareService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品库存(PmsSkuWare)表控制层
 *
 * @author makejava
 * @since 2022-12-02 23:55:27
 */
@RestController
@RequestMapping("/productService/pmsSkuWare")
public class PmsSkuWareController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSkuWareService pmsSkuWareService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
        ResponseEntity.ok(this.pmsSkuWareService.queryById(id));
        return null;
    }

    @GetMapping("/skuId/{skuId}")
    public KedomResponse queryBySkuId(@PathVariable("skuId") Long skuId) {
        return KedomResponse.okAddData(this.pmsSkuWareService.queryBySkuId(skuId));
    }

    /**
     * 新增数据
     * 商品第一次上架时，创建库存信息
     *
     * @param pmsSkuWare 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsSkuWare pmsSkuWare) {

        if ("".equals(pmsSkuWare.getSkuId())) {

            return new KedomResponse(KedomExceptionEnum.SKU_ID_NOT_EMPTY);
        }
        this.pmsSkuWareService.insert(pmsSkuWare);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsSkuWare 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse updateWare(PmsSkuWare pmsSkuWare) {
        this.pmsSkuWareService.updateWare(pmsSkuWare);
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

