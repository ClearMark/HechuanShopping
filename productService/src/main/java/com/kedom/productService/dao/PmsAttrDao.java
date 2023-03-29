package com.kedom.productService.dao;

import com.kedom.productService.entity.PmsAttr;
import com.kedom.productService.entity.vo.CategoryAttrVO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * 商品属性(PmsAttr)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-04 10:51:15
 */
@Mapper
public interface PmsAttrDao {

    /**
     * 通过ID查询单条数据
     *
     * @param attrId 主键
     * @return 实例对象
     */
    PmsAttr queryById(Long attrId);

    /**
     * 查询指定行数据
     *
     * @param pmsAttr 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PmsAttr> queryAllByLimit(PmsAttr pmsAttr, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsAttr 查询条件
     * @return 总行数
     */
    long count(PmsAttr pmsAttr);

    /**
     * 新增数据
     *
     * @param pmsAttr 实例对象
     * @return 影响行数
     */
    int insert(PmsAttr pmsAttr);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsAttr> 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(@Param("entities") List<PmsAttr> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsAttr> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    Integer insertOrUpdateBatch(@Param("entities") List<PmsAttr> entities);

    /**
     * 修改数据
     *
     * @param pmsAttr 实例对象
     * @return 影响行数
     */
    Byte update(PmsAttr pmsAttr);

    /**
     * 通过主键删除数据
     *
     * @param attrId 主键
     * @return 影响行数
     */
    Byte deleteById(Long attrId);

    int checkAttrIsExistAndEnable(String attrName, Integer attrGroupId, Long catelogId);


    List<CategoryAttrVO> queryAllAttrNameByCateId(Long catelogId);

    List<PmsAttr> getCategorySearchAttr(Long id);

    List<CategoryAttrVO> queryAllAttr(Integer offset);
}

