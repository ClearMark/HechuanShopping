package com.kedom.sellService.controller;

import com.kedom.sellService.entity.SmsShop;
import com.kedom.sellService.service.SmsShopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kedom.common.entity.KedomResponse;

import javax.annotation.Resource;

/**
 * 会员(SmsShop)表控制层
 *
 * @author makejava
 * @since 2023-02-28 10:27:22
 */
@RestController
@RequestMapping("/smsShop")
public class SmsShopController {
    /**
     * 服务对象
     */
    @Resource
    private SmsShopService smsShopService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.smsShopService.queryById(id));
    return null;
    }


    @GetMapping("/query/shop")
    public KedomResponse queryByUsername(String username) {
        ResponseEntity.ok(this.smsShopService.queryByUsername(username));
        return null;
    }

    /**
     * 新增数据
     *
     * @param smsShop 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(SmsShop smsShop) {
         this.smsShopService.insert(smsShop);
     return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param smsShop 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(SmsShop smsShop) {
         this.smsShopService.update(smsShop);
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

