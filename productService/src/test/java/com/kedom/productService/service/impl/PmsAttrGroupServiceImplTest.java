package com.kedom.productService.service.impl;

import com.kedom.productService.entity.PmsAttrGroup;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PmsAttrGroupServiceImplTest {
    @MockBean
    RedissonClient redissonClient;

    @Autowired
    private PmsAttrGroupServiceImpl pmsAttrGroupService;

    @Test
    void queryById() {
    }

    @Test
    void insert01() {
        PmsAttrGroup pmsAttrGroup=new PmsAttrGroup();
        pmsAttrGroup.setAttrGroupName("test-主题");
        pmsAttrGroup.setCatelogId(300L);
        pmsAttrGroup.setDescript("test-描述");
        pmsAttrGroup.setSort(1);
        pmsAttrGroup.setIcon("test-图标");
        pmsAttrGroupService.insert(pmsAttrGroup);
    }

    @Test
    void checkCategoryIsThereLevelCategory() {
    }

    @Test
    void checkAttrGroupUniqueOnCategory() {
    }

    @Test
    void update() {
    }

    @Test
    void queryAttrGroupByCateGoryId() {
    }

    @Test
    void checkAttrGroupIsExist() {
    }
}