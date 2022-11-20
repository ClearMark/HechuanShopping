package com.kedom.productService.service;

import com.kedom.productService.entity.PmsSpuImages;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import java.util.List;

/**
 * spu图片(PmsSpuImages)表服务接口
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
public interface PmsSpuImagesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSpuImages queryById(Long id);

    /**
     * 新增数据
     *
     * @param pmsSpuImages 实例对象
     * @return 实例对象
     */
    void insert(PmsSpuImages pmsSpuImages);

    /**
     * 修改数据
     *
     * @param pmsSpuImages 实例对象
     * @return 实例对象
     */
    void update(PmsSpuImages pmsSpuImages);


    void insertList(List<PmsSpuImages> images);
}
