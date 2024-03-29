package com.kedom.productService.dao;

import com.kedom.productService.entity.GetProductByCategoryVO;
import com.kedom.productService.entity.PmsSkuInfo;
import com.kedom.productService.entity.SkuHotVO;
import com.kedom.productService.entity.SkuImage;
import com.kedom.productService.entity.vo.Attr;
import com.kedom.productService.entity.vo.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;


/**
 * sku信息(PmsSkuInfo)表数据库访问层
 *
 * @author makejava
 * @since 2022-11-17 14:25:38
 */
@Mapper
public interface PmsSkuInfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param skuId 主键
     * @return 实例对象
     */
    PmsSkuInfo queryById(Long skuId);

    /**
     * 查询指定行数据
     *
     * @param pmsSkuInfo 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<PmsSkuInfo> queryAllByLimit(PmsSkuInfo pmsSkuInfo, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param pmsSkuInfo 查询条件
     * @return 总行数
     */
    long count(PmsSkuInfo pmsSkuInfo);

    /**
     * 新增数据
     *
     * @param pmsSkuInfo 实例对象
     * @return 影响行数
     */
    int insert(Sku pmsSkuInfo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSkuInfo> 实例对象列表
     * @return 影响行数
     */
    Integer insertBatch(@Param("entities") List<PmsSkuInfo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<PmsSkuInfo> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    Integer insertOrUpdateBatch(@Param("entities") List<PmsSkuInfo> entities);

    /**
     * 修改数据
     *
     * @param pmsSkuInfo 实例对象
     * @return 影响行数
     */
    Byte update(PmsSkuInfo pmsSkuInfo);

    /**
     * 通过主键删除数据
     *
     * @param skuId 主键
     * @return 影响行数
     */
    Byte deleteById(Long skuId);

    int insertGetKey(PmsSkuInfo pmsSkuInfo);

    Integer existsSkuBySkuId(Long skuId);

    PmsSkuInfo querySkuIntoWareInfoBySkuId(Long skuId);

    List<Sku> getHotProduct(@Param("offset") Integer offset, @Param("limit") Integer limit);

    List<Sku> getProductByUserId(Long userId);

    void updateProduct(Sku sku);

    List<PmsSkuInfo> queryByKey(@Param("keys") List<String> keys, @Param("offset") Integer offset);

    List<PmsSkuInfo> queryByCategory(@Param("pamrs") GetProductByCategoryVO pamrs, @Param("attrs") List<Attr> attrs);

    List<PmsSkuInfo> getRecommendProductByUser(@Param("userId") Integer userId, @Param("offset") Integer offset, @Param("limit") Integer limit);

    List<PmsSkuInfo> getSkuHot(SkuHotVO skuHotVO);

    void deleteProductById(Long id);

    void createOrderAddSaleCountAndDeletWara(@Param("id") Long skuId, @Param("count") Integer skuCount);

    Integer getSkuHotTotal(SkuHotVO skuHotVO);

    void setHot(PmsSkuInfo pmsSkuInfo);

    void addImage(SkuImage skuImage);

    void deleteImage(String id);

    List<SkuImage> productImage(String id);

    void takeDownProduct(Long id);
}

