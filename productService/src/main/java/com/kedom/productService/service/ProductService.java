package com.kedom.productService.service;

import com.kedom.productService.entity.GetProductByCategoryVO;
import com.kedom.productService.entity.vo.ProductVO;
import com.kedom.productService.entity.vo.Sku;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<ProductVO> getProduct(String spuKey, Integer pageNum, Integer pageSize);

    List<String> saveImage(List<MultipartFile> files);

    void addProduct(ProductVO productVO);

    Sku getProduct(Long id);

    List<Sku> getProductByKey(String spuKey, Integer offset);

    List<Sku> getProductByCategory(GetProductByCategoryVO pamrs);
}
