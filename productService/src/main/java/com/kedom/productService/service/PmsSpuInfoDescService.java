package com.kedom.productService.service;

import com.kedom.productService.entity.PmsSpuInfoDesc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * spu信息介绍(PmsSpuInfoDesc)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:39
 */
public interface PmsSpuInfoDescService {

    /**
     * 通过ID查询单条数据
     *
     * @param spuId 主键
     * @return 实例对象
     */
    PmsSpuInfoDesc queryById(Long spuId);

    /**
     * 新增数据
     *
     * @param pmsSpuInfoDesc 实例对象
     * @return 实例对象
     */
    void insert(PmsSpuInfoDesc pmsSpuInfoDesc);

    /**
     * 修改数据
     *
     * @param pmsSpuInfoDesc 实例对象
     * @return 实例对象
     */
    void update(PmsSpuInfoDesc pmsSpuInfoDesc);

   

}
