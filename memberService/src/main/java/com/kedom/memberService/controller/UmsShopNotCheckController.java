package com.kedom.memberService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.memberService.entity.UmsShopNotCheck;
import com.kedom.memberService.service.UmsShopNotCheckService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UmsShopNotCheck)表控制层
 *
 * @author makejava
 * @since 2023-04-07 18:04:59
 */
@RestController
@RequestMapping("/umsMember/umsShopNotCheck")
public class UmsShopNotCheckController {
    /**
     * 服务对象
     */
    @Resource
    private UmsShopNotCheckService umsShopNotCheckService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Integer id) {
        ResponseEntity.ok(this.umsShopNotCheckService.queryById(id));
        return null;
    }

    @PostMapping("/checkShop")
    public KedomResponse checkShop(@RequestBody UmsShopNotCheck umsShopNotCheck) {
        umsShopNotCheckService.checkShop(umsShopNotCheck);
        return KedomResponse.ok();
    }

    //首页查询店铺信息
    @GetMapping("/user/{id}")
    public KedomResponse userShop(@PathVariable("id") Long id) {
        UmsShopNotCheck umsShopNotCheck = umsShopNotCheckService.userShop(id);
        return KedomResponse.okAddData(umsShopNotCheck);
    }

    @GetMapping("/delete/{id}")
    public KedomResponse deleteShopCheck(@PathVariable("id") Long id) {
        UmsShopNotCheck umsShopNotCheck = umsShopNotCheckService.deleteShopCheck(id);
        return KedomResponse.ok();
    }


    /**
     * 新增数据
     *
     * @param umsShopNotCheck 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public KedomResponse add(@RequestBody UmsShopNotCheck umsShopNotCheck) {
        this.umsShopNotCheckService.insert(umsShopNotCheck);
        return KedomResponse.ok();
    }

    @GetMapping("/allNotCheck")
    public KedomResponse allNotCheck() {
        List<UmsShopNotCheck> list = this.umsShopNotCheckService.allNotCheck();
        return KedomResponse.okAddData(list);
    }

    /**
     * 编辑数据
     *
     * @param umsShopNotCheck 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(UmsShopNotCheck umsShopNotCheck) {
        this.umsShopNotCheckService.update(umsShopNotCheck);
        return KedomResponse.ok();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public KedomResponse deleteById(Integer id) {
        return null;
    }

}

