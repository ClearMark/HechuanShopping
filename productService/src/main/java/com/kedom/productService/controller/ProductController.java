package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.vo.ProductVO;
import com.kedom.productService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/productService/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/getProduct")
    public String getProduct() {
        return "getProduct";
    }

    //通过关键词获取商品
    @RequestMapping("/getProduct/{spuKey}/{pageNum}/{pageSize}")
    public KedomResponse getProduct(@PathVariable("spuKey") String spuKey, @PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize) {
        //商品外面仅展示商品的基本信息，不展示商品的详情信息
        List<ProductVO> spuList = productService.getProduct(spuKey, pageNum, pageSize);
        return KedomResponse.okAddData(spuList);
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
}
