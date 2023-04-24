package com.kedom.productService.dao;

import com.kedom.productService.entity.CancelOrderVO;
import com.kedom.productService.entity.OrderItemVO;
import com.kedom.productService.entity.PmsOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * 订单项信息(PmsOrderItem)表数据库访问层
 *
 * @author makejava
 * @since 2023-04-11 14:11:35
 */
@Mapper
public interface PmsOrderItemDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    PmsOrderItem queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param pmsOrderItem 查询条件
     * @param pageable     分页对象
     * @return 对象列表
     */
    List<PmsOrderItem> queryAllByLimit(PmsOrderItem pmsOrderItem, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsOrderItem 查询条件
     * @return 总行数
     */
    long count(PmsOrderItem pmsOrderItem);

    /**
     * 新增数据
     *
     * @param pmsOrderItem 实例对象
     * @return 影响行数
     */
    int insert(PmsOrderItem pmsOrderItem);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsOrderItem> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<PmsOrderItem> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsOrderItem> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<PmsOrderItem> entities);

    /**
     * 修改数据
     *
     * @param pmsOrderItem 实例对象
     * @return 影响行数
     */
    int update(PmsOrderItem pmsOrderItem);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    void batchAdd(List<PmsOrderItem> orderItem);

    List<PmsOrderItem> queryByOrderId(@Param("order_sn") String order_sn);

    List<OrderItemVO> queryOrderItemByUserId(@Param("userId") String userId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    List<PmsOrderItem> queryByOrderSn(String orderSn);

    void cancelOrder(CancelOrderVO cancelOrderVO);

    Integer queryOrderItemByUserIdTotal(@Param("userId") String userId);

    void ok(CancelOrderVO cancelOrderVO);

    List<String> queryOrderItemStatusByOrderSn(String orderSn);

    void cancelBigOrder(CancelOrderVO cancelOrderVO);
}

