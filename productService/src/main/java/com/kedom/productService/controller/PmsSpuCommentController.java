package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.PmsSpuComment;
import com.kedom.productService.service.PmsSpuCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 商品评价(PmsSpuComment)表控制层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@RestController
@RequestMapping("/pmsSpuComment")
public class PmsSpuCommentController {
    /**
     * 服务对象
     */
    @Resource
    private PmsSpuCommentService pmsSpuCommentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
         ResponseEntity.ok(this.pmsSpuCommentService.queryById(id));
    return null;
    }

    /**
     * 新增数据
     *
     * @param pmsSpuComment 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsSpuComment pmsSpuComment) {
         this.pmsSpuCommentService.insert(pmsSpuComment);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsSpuComment 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsSpuComment pmsSpuComment) {
         this.pmsSpuCommentService.update(pmsSpuComment);
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

