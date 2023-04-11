package com.kedom.memberService.dao;

import com.kedom.memberService.entity.UmsShop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 会员(UmsShop)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-06 15:18:55
 */
@Mapper
public interface UmsShopDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsShop queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param umsShop  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<UmsShop> queryAllByLimit(UmsShop umsShop, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param umsShop 查询条件
     * @return 总行数
     */
    long count(UmsShop umsShop);

    /**
     * 新增数据
     *
     * @param umsShop 实例对象
     * @return 影响行数
     */
    int insert(UmsShop umsShop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsShop> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsShop> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsShop> entities);

    /**
     * 修改数据
     *
     * @param umsShop 实例对象
     * @return 影响行数
     */
    int update(UmsShop umsShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    UmsShop queryByUserId(Long id);
}

