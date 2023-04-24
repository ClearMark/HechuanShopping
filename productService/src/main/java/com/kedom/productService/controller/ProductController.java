package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.GetProductByCategoryVO;
import com.kedom.productService.entity.vo.ProductVO;
import com.kedom.productService.entity.vo.Sku;
import com.kedom.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/productService/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/{id}")
    public KedomResponse getProduct(@PathVariable("id") Long id) {
        Sku sku = productService.getProduct(id);
        return KedomResponse.okAddData(sku);
    }

    @GetMapping("takeDownProduct/{id}")
    public KedomResponse takeDownProduct(@PathVariable("id") Long id) {
        productService.takeDownProduct(id);
        return KedomResponse.ok();
    }

    //通过关键词获取商品
    @RequestMapping("/key/{spuKey}/{offset}")
    public KedomResponse getProduct(@PathVariable("spuKey") String spuKey, @PathVariable("offset") Integer offset) {
        //商品外面仅展示商品的基本信息，不展示商品的详情信息
        List<Sku> skus = productService.getProductByKey(spuKey, offset);
        return KedomResponse.okAddData(skus);
    }

    //通过分类获取商品


    @PostMapping("/saveFile")
    public KedomResponse saveFile(List<MultipartFile> files) {
        List<String> paths = productService.saveImage(files);
        return KedomResponse.okAddData(paths);
    }

    @PostMapping
    public KedomResponse addProduct(ProductVO productVO) {
        productService.addProduct(productVO);
        return KedomResponse.ok();
    }

    @PostMapping("/getProductByCategory")
    public KedomResponse getProductByCategory(@RequestBody GetProductByCategoryVO pamrs) {
        List<Sku> skus = productService.getProductByCategory(pamrs);
        return KedomResponse.okAddData(skus);
    }


}
