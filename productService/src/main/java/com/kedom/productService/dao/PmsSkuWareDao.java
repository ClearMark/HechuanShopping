package com.kedom.productService.dao;

import com.kedom.productService.entity.PmsSkuInfo;
import com.kedom.productService.entity.PmsSkuWare;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 商品库存(PmsSkuWare)表数据库访问层
 *
 * @author makejava
 * @since 2022-12-02 23:55:27
 */
@Mapper
public interface PmsSkuWareDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSkuWare queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pmsSkuWare 查询条件
     * @param pageable   分页对象
     * @return 对象列表
     */
    List<PmsSkuWare> queryAllByLimit(PmsSkuWare pmsSkuWare, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsSkuWare 查询条件
     * @return 总行数
     */
    long count(PmsSkuWare pmsSkuWare);

    /**
     * 新增数据
     *
     * @param pmsSkuWare 实例对象
     * @return 影响行数
     */
    int insert(PmsSkuWare pmsSkuWare);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSkuWare> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PmsSkuWare> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSkuWare> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PmsSkuWare> entities);

    /**
     * 修改数据
     *
     * @param pmsSkuWare 实例对象
     * @return 影响行数
     */
    int update(PmsSkuWare pmsSkuWare);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    int existsSkuWareBySkuId(Long skuId);

    Integer updateWare(PmsSkuInfo pmsSkuInfo);
}

