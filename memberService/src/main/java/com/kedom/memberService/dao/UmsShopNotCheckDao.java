package com.kedom.memberService.dao;

import com.kedom.memberService.entity.UmsShopNotCheck;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * (UmsShopNotCheck)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-07 18:04:59
 */
@Mapper
public interface UmsShopNotCheckDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsShopNotCheck queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param umsShopNotCheck 查询条件
     * @param pageable        分页对象
     * @return 对象列表
     */
    List<UmsShopNotCheck> queryAllByLimit(UmsShopNotCheck umsShopNotCheck, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param umsShopNotCheck 查询条件
     * @return 总行数
     */
    long count(UmsShopNotCheck umsShopNotCheck);

    /**
     * 新增数据
     *
     * @param umsShopNotCheck 实例对象
     * @return 影响行数
     */
    int insert(UmsShopNotCheck umsShopNotCheck);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsShopNotCheck> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsShopNotCheck> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsShopNotCheck> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsShopNotCheck> entities);

    /**
     * 修改数据
     *
     * @param umsShopNotCheck 实例对象
     * @return 影响行数
     */
    int update(UmsShopNotCheck umsShopNotCheck);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<UmsShopNotCheck> allNotCheck();

    void checkShop(UmsShopNotCheck umsShopNotCheck);
}

