package com.kedom.memberService.dao;

import com.kedom.memberService.entity.UmsMemberReceiveAddress;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;


/**
 * 会员收货地址(UmsMemberReceiveAddress)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-17 22:36:25
 */
@Mapper
public interface UmsMemberReceiveAddressDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsMemberReceiveAddress queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param umsMemberReceiveAddress 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<UmsMemberReceiveAddress> queryAllByLimit(UmsMemberReceiveAddress umsMemberReceiveAddress, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param umsMemberReceiveAddress 查询条件
     * @return 总行数
     */
    long count(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 新增数据
     *
     * @param umsMemberReceiveAddress 实例对象
     * @return 影响行数
     */
    int insert(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsMemberReceiveAddress> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsMemberReceiveAddress> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsMemberReceiveAddress> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsMemberReceiveAddress> entities);

    /**
     * 修改数据
     *
     * @param umsMemberReceiveAddress 实例对象
     * @return 影响行数
     */
    int update(UmsMemberReceiveAddress umsMemberReceiveAddress);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<UmsMemberReceiveAddress> queryMemberById(Long id);
}

