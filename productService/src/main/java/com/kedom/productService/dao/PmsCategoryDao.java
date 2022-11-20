package com.kedom.productService.dao;

import com.kedom.common.entity.productServiceEntity.PmsCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;



/**
 * 商品三级分类(PmsCategory)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-02 21:10:03
 */
@Mapper
public interface PmsCategoryDao {

    /**
     * 通过ID查询单条数据
     *
     * @param catId 主键
     * @return 实例对象
     */
    PmsCategory queryById(Long catId);


    List<PmsCategory> queryAll();

    /**
     * 统计总行数
     *
     * @param pmsCategory 查询条件
     * @return 总行数
     */
    long count(PmsCategory pmsCategory);

    /**
     * 新增数据
     *
     * @param pmsCategory 实例对象
     * @return 影响行数
     */
    int insert(PmsCategory pmsCategory);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsCategory> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PmsCategory> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsCategory> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PmsCategory> entities);

    /**
     * 修改数据
     *
     * @param pmsCategory 实例对象
     * @return 影响行数
     */
    int update(PmsCategory pmsCategory);

    /**
     * 通过主键删除数据
     *
     * @param catId 主键
     * @return 影响行数
     */
    int deleteById(Long catId);

    int deleteCategorysById(List<Long> ids);

    int checkCategoryIsThreeLevelCategory(Long cateId);
}

