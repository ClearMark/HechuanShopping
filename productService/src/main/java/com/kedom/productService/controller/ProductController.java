package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.vo.ProductVO;
import com.kedom.productService.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    @RequestMapping("/getProduct")
    public String getProduct() {
        return "getProduct";
    }

    @PostMapping("/saveFile")
    public KedomResponse saveFile(List<MultipartFile> files) {
        List<String> paths = productServiceImpl.saveImage(files);
        return KedomResponse.OK_FULLData(paths);
    }

    @PostMapping
    public KedomResponse addProduct(ProductVO productVO) {
        productServiceImpl.addProduct(productVO);
        return KedomResponse.OK();
    }
}
