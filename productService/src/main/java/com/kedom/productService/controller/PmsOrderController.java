package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.OrderVO;
import com.kedom.productService.entity.PmsOrder;
import com.kedom.productService.service.PmsOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PmsOrder)表控制层
 *
 * @author makejava
 * @since 2023-04-11 14:11:34
 */
@RestController
@RequestMapping("/productService/pmsOrder")
public class PmsOrderController {
    /**
     * 服务对象
     */
    @Resource
    private PmsOrderService pmsOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
        ResponseEntity.ok(this.pmsOrderService.queryById(id));
        return null;
    }

    /**
     * 新增数据
     *
     * @param pmsOrder 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public KedomResponse add(@RequestBody OrderVO pmsOrder) {
        this.pmsOrderService.createOrder(pmsOrder);
        return KedomResponse.ok();
    }

    @GetMapping("/user/{id}/{offset}/{limit}")
    public KedomResponse queryByUserId(@PathVariable("id") Long id, @PathVariable("offset") Integer offset, @PathVariable("limit") Integer limit) {
        List<PmsOrder> list = this.pmsOrderService.queryByUserId(id, offset, limit);
        return KedomResponse.okAddData(list);
    }

    /**
     * 编辑数据
     *
     * @param pmsOrder 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsOrder pmsOrder) {
        this.pmsOrderService.update(pmsOrder);
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

