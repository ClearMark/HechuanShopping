package com.kedom.memberService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.memberService.entity.AdminEditPasswordDTO;
import com.kedom.memberService.entity.UmsAdmin;
import com.kedom.memberService.service.UmsAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UmsAdmin)表控制层
 *
 * @author makejava
 * @since 2023-04-16 21:03:33
 */
@RestController
@RequestMapping("/umsMember/umsAdmin")
public class UmsAdminController {
    /**
     * 服务对象
     */
    @Resource
    private UmsAdminService umsAdminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Integer id) {
        ResponseEntity.ok(this.umsAdminService.queryById(id));
        return null;
    }

    @PostMapping("/login")
    public KedomResponse login(@RequestBody UmsAdmin umsAdmin) {

        return KedomResponse.okAddData(this.umsAdminService.login(umsAdmin));
    }

    @PostMapping("/edit/password")
    public KedomResponse editPassword(@RequestBody AdminEditPasswordDTO umsAdmin) {

        return KedomResponse.okAddData(this.umsAdminService.editPassword(umsAdmin));
    }

    /**
     * 新增数据
     *
     * @param umsAdmin 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public KedomResponse add(@RequestBody UmsAdmin umsAdmin) {
        this.umsAdminService.insert(umsAdmin);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param umsAdmin 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(UmsAdmin umsAdmin) {
        this.umsAdminService.update(umsAdmin);
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

