package com.kedom.memberService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.memberService.entity.UmsCar;
import com.kedom.memberService.service.UmsCarService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (UmsCar)表控制层
 *
 * @author makejava
 * @since 2023-04-06 14:21:32
 */
@RestController
@RequestMapping("/umsMember/umsCar")
public class UmsCarController {
    /**
     * 服务对象
     */
    @Resource
    private UmsCarService umsCarService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}/{offset}/{limit}")
    public KedomResponse queryById(@PathVariable("id") Integer id, @PathVariable Integer offset, @PathVariable Integer limit) {
        List<UmsCar> list = this.umsCarService.queryByUserId(id, offset, limit);
        return KedomResponse.okAddData(list);
    }

    @GetMapping("/detete/{id}")
    public KedomResponse deteteById(@PathVariable("id") Integer id) {
        this.umsCarService.deleteById(id);
        return KedomResponse.ok();
    }

    /**
     * 新增数据
     *
     * @param umsCar 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public KedomResponse add(@RequestBody UmsCar umsCar) {
        this.umsCarService.insert(umsCar);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param umsCar 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public KedomResponse edit(@RequestBody UmsCar umsCar) {
        this.umsCarService.update(umsCar);
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

