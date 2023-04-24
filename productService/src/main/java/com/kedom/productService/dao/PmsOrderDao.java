package com.kedom.productService.dao;

import com.kedom.productService.entity.CancelOrderVO;
import com.kedom.productService.entity.PmsOrder;
import com.kedom.productService.vo.OrderSearchVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * (PmsOrder)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-11 14:11:34
 */
@Mapper
public interface PmsOrderDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsOrder queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pmsOrder 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<PmsOrder> queryAllByLimit(PmsOrder pmsOrder, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsOrder 查询条件
     * @return 总行数
     */
    long count(PmsOrder pmsOrder);

    /**
     * 新增数据
     *
     * @param pmsOrder 实例对象
     * @return 影响行数
     */
    int insert(PmsOrder pmsOrder);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsOrder> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PmsOrder> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsOrder> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PmsOrder> entities);

    /**
     * 修改数据
     *
     * @param pmsOrder 实例对象
     * @return 影响行数
     */
    int update(PmsOrder pmsOrder);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    List<PmsOrder> queryByUserId(@Param("userId") Long userId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    List<PmsOrder> queryAdmin(OrderSearchVO orderSearchVO);

    Integer queryAdminTotal(OrderSearchVO orderSearchVO);

    void cancelOrder(CancelOrderVO cancelOrderVO);
}

