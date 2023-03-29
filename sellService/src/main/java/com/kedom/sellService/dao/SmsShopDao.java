package com.kedom.sellService.dao;

import com.kedom.sellService.entity.SmsShop;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员(SmsShop)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-28 10:27:24
 */
@Mapper
public interface SmsShopDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SmsShop queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param smsShop 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */

    /**
     * 统计总行数
     *
     * @param smsShop 查询条件
     * @return 总行数
     */
    long count(SmsShop smsShop);

    /**
     * 新增数据
     *
     * @param smsShop 实例对象
     * @return 影响行数
     */
    int insert(SmsShop smsShop);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SmsShop> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SmsShop> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SmsShop> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SmsShop> entities);

    /**
     * 修改数据
     *
     * @param smsShop 实例对象
     * @return 影响行数
     */
    int update(SmsShop smsShop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    SmsShop queryByUsername(String username);
}

