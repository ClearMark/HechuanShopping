package com.kedom.productService.service;

import com.kedom.productService.entity.PmsSpuInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * spu信息(PmsSpuInfo)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public interface PmsSpuInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSpuInfo queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsSpuInfo 实例对象
     * @return 实例对象
     */
    void insert(PmsSpuInfo pmsSpuInfo);

    /**
     * 修改数据
     *
     * @param pmsSpuInfo 实例对象
     * @return 实例对象
     */
    void update(PmsSpuInfo pmsSpuInfo);


    void insertGetKey(PmsSpuInfo pmsSpuInfo);
}
