package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsSkuInfo;
import com.kedom.productService.entity.vo.Sku;
import com.kedom.productService.service.PmsSkuInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * sku信息(PmsSkuInfo)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/productService/pmsSkuInfo")
public class PmsSkuInfoController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSkuInfoService pmsSkuInfoService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsSkuInfoService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsSkuInfo 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public KedomResponse add(@RequestBody Sku pmsSkuInfo) {
        this.pmsSkuInfoService.insert(pmsSkuInfo);
        return KedomResponse.ok();
    }

    @GetMapping("/getHotProduct/{offset}/{limit}")
    public KedomResponse getHotProduct(@PathVariable("offset") Integer offset, @PathVariable("limit") Integer limit) {
        return KedomResponse.okAddData(this.pmsSkuInfoService.getHotProduct(offset, limit));
    }

    @GetMapping("/getRecommendProductByUser/{userId}/{offset}/{limit}")
    public KedomResponse getRecommendProductByUser(@PathVariable Integer userId, @PathVariable("offset") Integer offset, @PathVariable("limit") Integer limit) {
        Object recommendProductByUser = this.pmsSkuInfoService.getRecommendProductByUser(userId, offset, limit);
        return KedomResponse.okAddData(recommendProductByUser);
    }


    @GetMapping("/getProductByUserId/{userId}")
    public KedomResponse getProductByUserId(@PathVariable("userId") Long userId) {
        return KedomResponse.okAddData(this.pmsSkuInfoService.getProductByUserId(userId));
    }

    @PostMapping("/updateProduct")
    public KedomResponse updateProduct(@RequestBody Sku sku) {
        pmsSkuInfoService.updateProduct(sku);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsSkuInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsSkuInfo pmsSkuInfo) {
        this.pmsSkuInfoService.update(pmsSkuInfo);
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

