package com.kedom.memberService.controller;

import com.kedom.common.entity.KedomResponse;
import com.kedom.memberService.entity.ShopInfoVO;
import com.kedom.memberService.entity.UmsShop;
import com.kedom.memberService.service.UmsShopService;
import com.kedom.productService.entity.ShopSearchVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 会员(UmsShop)表控制层
 *
 * @author makejava
 * @since 2023-04-06 15:18:55
 */
@RestController
@RequestMapping("/umsMember/umsShop")
public class UmsShopController {
    /**
     * 服务对象
     */
    @Resource
    private UmsShopService umsShopService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/user/{id}")
    public KedomResponse queryById(@PathVariable("id") Long id) {
        UmsShop data = this.umsShopService.queryByUserId(id);
        if (data == null || data.getId() == null) {
            return KedomResponse.okAddData(0);
        } else {
            return KedomResponse.okAddData(data);
        }
    }

    @GetMapping("/shopIndo/{id}")
    public KedomResponse getShopIndo(@PathVariable("id") Long id) {
        ShopInfoVO data = this.umsShopService.getShopIndo(id);
        return KedomResponse.okAddData(data);
    }

    /**
     * 新增数据
     *
     * @param umsShop 实体
     * @return 新增结果
     */
    @PostMapping
    public KedomResponse add(UmsShop umsShop) {
        this.umsShopService.insert(umsShop);
        return KedomResponse.ok();
    }

    @PostMapping("/queryAll")
    public KedomResponse queryAll(@RequestBody ShopSearchVO umsShop) {
        List<ShopInfoVO> data = this.umsShopService.queryAll(umsShop);
        Integer total = this.umsShopService.queryAllTotal(umsShop);
        return KedomResponse.dataAndTotal(data, total);
    }

    /**
     * 编辑数据
     *
     * @param umsShop 实体
     * @return 编辑结果
     */
    @PutMapping
    public KedomResponse edit(UmsShop umsShop) {
        this.umsShopService.update(umsShop);
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

