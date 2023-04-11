package com.kedom.memberService.dao;

import com.kedom.memberService.entity.UmsCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * (UmsCar)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-06 14:21:32
 */
@Mapper
public interface UmsCarDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsCar queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param umsCar   查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<UmsCar> queryAllByLimit(UmsCar umsCar, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param umsCar 查询条件
     * @return 总行数
     */
    long count(UmsCar umsCar);

    /**
     * 新增数据
     *
     * @param umsCar 实例对象
     * @return 影响行数
     */
    int insert(UmsCar umsCar);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsCar> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsCar> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsCar> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsCar> entities);

    /**
     * 修改数据
     *
     * @param umsCar 实例对象
     * @return 影响行数
     */
    int update(UmsCar umsCar);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Integer deleteById(Integer id);

    List<UmsCar> queryByUserId(@Param("id") Integer id, @Param("offset") Integer offset, @Param("limit") Integer limit);
}

