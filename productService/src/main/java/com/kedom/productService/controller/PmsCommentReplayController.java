package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsCommentReplay;
import com.kedom.productService.service.PmsCommentReplayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品评价回复关系(PmsCommentReplay)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/pmsCommentReplay")
public class PmsCommentReplayController {
    /**
     * 服务对象
     */
    @Resource
    private PmsCommentReplayService pmsCommentReplayService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsCommentReplayService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsCommentReplay 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsCommentReplay pmsCommentReplay) {
         this.pmsCommentReplayService.insert(pmsCommentReplay);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsCommentReplay 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsCommentReplay pmsCommentReplay) {
         this.pmsCommentReplayService.update(pmsCommentReplay);
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

