package com.kedom.productService.service.impl;

import com.kedom.productService.ProductServiceApplication;
import com.kedom.productService.entity.vo.BaseAttrs;
import com.kedom.productService.entity.vo.ProductVO;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ProductServiceApplication.class)
class ProductServiceImplTest {

    @MockBean
    RedissonClient redissonClient;
    @Autowired
    ProductServiceImpl productService;

    @Test
    void addProduct01() {
        ProductVO productVO = new ProductVO();
        createVO01(productVO);
        productService.addProduct(productVO);

    }

    private void createVO01(ProductVO productVO)
    {
        productVO.setSpuName("测试商品");
        productVO.setSpuDescription("测试商品说明");
        productVO.setCatalogId(300L);
        productVO.setDecript(Arrays.asList("测试商品描述1","测试商品描述2"));
        productVO.setImages(Arrays.asList("测试商品图片1","测试商品图片2"));
        productVO.setBaseAttrs(Arrays.asList(new BaseAttrs(7L,"测试商品属性1"),new BaseAttrs(8L,"测试商品属性2")));

    }


    @Test
    void a() {
        productService.a();
    }
}