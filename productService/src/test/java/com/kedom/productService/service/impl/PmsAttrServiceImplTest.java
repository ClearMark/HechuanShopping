package com.kedom.productService.service.impl;

import com.kedom.productService.entity.PmsAttr;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PmsAttrServiceImplTest {
    @MockBean
    RedissonClient redissonClient;
    @Autowired
    private PmsAttrServiceImpl pmsAttrService;

    @Test
    void insert01() {
        PmsAttr pmsAttr=new PmsAttr();
        pmsAttr.setAttrName("test-属性名称");
       pmsAttr.setCatelogId(300L);
         pmsAttr.setAttrGroupId(3);
         pmsAttr.setEnable(1L);
        pmsAttrService.insert(pmsAttr);
    }
    @Test
    void insert02() {
        PmsAttr pmsAttr=new PmsAttr();
        pmsAttr.setAttrName("test-属性名称1");
        pmsAttr.setCatelogId(300L);
        pmsAttr.setAttrGroupId(3);
        pmsAttr.setEnable(1L);
        pmsAttrService.insert(pmsAttr);
    }
}