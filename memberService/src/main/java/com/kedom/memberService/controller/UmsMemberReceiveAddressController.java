package com.kedom.memberService.controller;

import com.kedom.memberService.entity.UmsMemberReceiveAddress;
import com.kedom.memberService.service.UmsMemberReceiveAddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.kedom.common.entity.KedomResponse;

import javax.annotation.Resource;

/**
 * 会员收货地址(UmsMemberReceiveAddress)表控制层
 *
 * @author makejava
 * @since 2023-03-17 22:36:23
 */
@RestController
@RequestMapping("/umsMember/umsMemberReceiveAddress")
public class UmsMemberReceiveAddressController {
    /**
     * 服务对象
     */
    @Resource
    private UmsMemberReceiveAddressService umsMemberReceiveAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.umsMemberReceiveAddressService.queryById(id));
    return null;
    }

    @GetMapping("/member/{id}")
    public KedomResponse queryMemberById(@PathVariable("id") Long id) {
      return   KedomResponse.okAddData(this.umsMemberReceiveAddressService.queryMemberById(id));
    }

    /**
     * 新增数据
     *
     * @param umsMemberReceiveAddress 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(@RequestBody UmsMemberReceiveAddress umsMemberReceiveAddress) {
         this.umsMemberReceiveAddressService.insert(umsMemberReceiveAddress);
     return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param umsMemberReceiveAddress 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(UmsMemberReceiveAddress umsMemberReceiveAddress) {
         this.umsMemberReceiveAddressService.update(umsMemberReceiveAddress);
     return KedomResponse.ok();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{id}")
    public KedomResponse deleteById(@PathVariable("id") Long id) {
        this.umsMemberReceiveAddressService.delete(id);
        return KedomResponse.ok();
    }

}

