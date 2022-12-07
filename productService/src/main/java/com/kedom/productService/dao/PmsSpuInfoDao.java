package com.kedom.productService.dao;

import com.kedom.productService.entity.PmsSpuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * spu信息(PmsSpuInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Mapper
public interface PmsSpuInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSpuInfo queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pmsSpuInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PmsSpuInfo> queryAllByLimit(PmsSpuInfo pmsSpuInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsSpuInfo 查询条件
     * @return 总行数
     */
    long count(PmsSpuInfo pmsSpuInfo);

    /**
     * 新增数据
     *
     * @param pmsSpuInfo 实例对象
     * @return 影响行数
     */
    Integer insert(PmsSpuInfo pmsSpuInfo);


    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSpuInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    Integer insertOrUpdateBatch(@Param("entities") List<PmsSpuInfo> entities);

    /**
     * 修改数据
     *
     * @param pmsSpuInfo 实例对象
     * @return 影响行数
     */
    Integer update(PmsSpuInfo pmsSpuInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Byte deleteById(Long id);

    int insertGetKey(PmsSpuInfo pmsSpuInfo);

    Integer spuPutOnShelves(PmsSpuInfo pmsSpuInfo);

    List<PmsSpuInfo> queryBySpuNameAndPage(String spuKey, Integer pageNum, Integer pageSize);
}

