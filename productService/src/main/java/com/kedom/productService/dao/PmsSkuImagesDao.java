package com.kedom.productService.dao;

import com.kedom.productService.entity.PmsSkuImages;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * sku图片(PmsSkuImages)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Mapper
public interface PmsSkuImagesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSkuImages queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pmsSkuImages 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PmsSkuImages> queryAllByLimit(PmsSkuImages pmsSkuImages, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsSkuImages 查询条件
     * @return 总行数
     */
    long count(PmsSkuImages pmsSkuImages);

    /**
     * 新增数据
     *
     * @param pmsSkuImages 实例对象
     * @return 影响行数
     */
    Byte insert(PmsSkuImages pmsSkuImages);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSkuImages> 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(@Param("entities") List<PmsSkuImages> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSkuImages> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    Integer insertOrUpdateBatch(@Param("entities") List<PmsSkuImages> entities);

    /**
     * 修改数据
     *
     * @param pmsSkuImages 实例对象
     * @return 影响行数
     */
    Byte update(PmsSkuImages pmsSkuImages);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Byte deleteById(Long id);

    int insertList(List<PmsSkuImages> skuImages);
}

