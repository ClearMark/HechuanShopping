package com.kedom.productService.dao;

import com.kedom.productService.entity.PmsProductAttrValue;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * spu属性值(PmsProductAttrValue)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Mapper
public interface PmsProductAttrValueDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsProductAttrValue queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pmsProductAttrValue 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PmsProductAttrValue> queryAllByLimit(PmsProductAttrValue pmsProductAttrValue, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsProductAttrValue 查询条件
     * @return 总行数
     */
    long count(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 新增数据
     *
     * @param pmsProductAttrValue 实例对象
     * @return 影响行数
     */
    Byte insert(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsProductAttrValue> 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(@Param("entities") List<PmsProductAttrValue> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsProductAttrValue> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    Integer insertOrUpdateBatch(@Param("entities") List<PmsProductAttrValue> entities);

    /**
     * 修改数据
     *
     * @param pmsProductAttrValue 实例对象
     * @return 影响行数
     */
    Byte update(PmsProductAttrValue pmsProductAttrValue);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Byte deleteById(Long id);

    int insertList(List<PmsProductAttrValue> skuAttrValues);
}

