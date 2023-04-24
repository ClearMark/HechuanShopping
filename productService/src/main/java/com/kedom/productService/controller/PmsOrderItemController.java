package com.kedom.productService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.productService.entity.CancelOrderVO;
import com.kedom.productService.entity.OrderItemVO;
import com.kedom.productService.entity.PmsOrderItem;
import com.kedom.productService.service.PmsOrderItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 订单项信息(PmsOrderItem)表控制层
 *
 * @author makejava
 * @since 2023-04-11 14:11:35
 */
@RestController
@RequestMapping("/productService/pmsOrderItem")
public class PmsOrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private PmsOrderItemService pmsOrderItemService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
        ResponseEntity.ok(this.pmsOrderItemService.queryById(id));
        return null;
    }

    @PostMapping("/cancel")
    public KedomResponse cancel(@RequestBody CancelOrderVO cancelOrderVO) {
        pmsOrderItemService.cancel(cancelOrderVO);
        return KedomResponse.ok();
    }


    @GetMapping("/OrderId/{id}")
    public KedomResponse queryByOrderId(@PathVariable("id") String id) {
        return KedomResponse.okAddData(this.pmsOrderItemService.queryByOrderId(id));
    }

    @GetMapping("/orderItem/{userId}/{offset}/{limit}")
    public KedomResponse queryOrderItemByUserId(@PathVariable("userId") String userId, @PathVariable("offset") Integer offset, @PathVariable("limit") Integer limit) {
        List<OrderItemVO> data = this.pmsOrderItemService.queryOrderItemByUserId(userId, offset, limit);
        Integer total = this.pmsOrderItemService.queryOrderItemByUserIdTotal(userId);
        return KedomResponse.dataAndTotal(data, total);
    }

    @PostMapping("/ok")
    public KedomResponse ok(@RequestBody CancelOrderVO cancelOrderVO) {
        this.pmsOrderItemService.ok(cancelOrderVO);
        return KedomResponse.ok();
    }

    /**
     * 新增数据
     *
     * @param pmsOrderItem 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(PmsOrderItem pmsOrderItem) {
        this.pmsOrderItemService.insert(pmsOrderItem);
        return KedomResponse.ok();
    }

    /**
     * 编辑数据
     *
     * @param pmsOrderItem 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(PmsOrderItem pmsOrderItem) {
        this.pmsOrderItemService.update(pmsOrderItem);
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

