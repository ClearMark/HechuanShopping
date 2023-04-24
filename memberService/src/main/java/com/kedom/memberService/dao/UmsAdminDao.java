package com.kedom.memberService.dao;

import com.kedom.memberService.entity.AdminEditPasswordDTO;
import com.kedom.memberService.entity.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * (UmsAdmin)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-16 21:03:33
 */
@Mapper
public interface UmsAdminDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsAdmin queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param umsAdmin 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<UmsAdmin> queryAllByLimit(UmsAdmin umsAdmin, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param umsAdmin 查询条件
     * @return 总行数
     */
    long count(UmsAdmin umsAdmin);

    /**
     * 新增数据
     *
     * @param umsAdmin 实例对象
     * @return 影响行数
     */
    int insert(UmsAdmin umsAdmin);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsAdmin> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsAdmin> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsAdmin> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsAdmin> entities);

    /**
     * 修改数据
     *
     * @param umsAdmin 实例对象
     * @return 影响行数
     */
    int update(UmsAdmin umsAdmin);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Integer login(UmsAdmin umsAdmin);

    Integer editPassword(AdminEditPasswordDTO umsAdmin);
}

