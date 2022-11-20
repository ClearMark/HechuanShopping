package com.kedom.productService.dao;

import com.kedom.productService.entity.PmsSpuComment;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * 商品评价(PmsSpuComment)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Mapper
public interface PmsSpuCommentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsSpuComment queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pmsSpuComment 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PmsSpuComment> queryAllByLimit(PmsSpuComment pmsSpuComment, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsSpuComment 查询条件
     * @return 总行数
     */
    long count(PmsSpuComment pmsSpuComment);

    /**
     * 新增数据
     *
     * @param pmsSpuComment 实例对象
     * @return 影响行数
     */
    Byte insert(PmsSpuComment pmsSpuComment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSpuComment> 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(@Param("entities") List<PmsSpuComment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSpuComment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    Integer insertOrUpdateBatch(@Param("entities") List<PmsSpuComment> entities);

    /**
     * 修改数据
     *
     * @param pmsSpuComment 实例对象
     * @return 影响行数
     */
    Byte update(PmsSpuComment pmsSpuComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    Byte deleteById(Long id);

}

