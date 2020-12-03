package com.xzy.mall.dao;

import com.xzy.mall.entity.SkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * sku表(SkuStock)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-03 09:13:13
 */
public interface SkuStockDao {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SkuStock queryById(Object id);
    
    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SkuStock> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);
    
    
    /**
     * 通过实体作为筛选条件查询
     *
     * @param skuStock 实例对象
     * @return 对象列表
     */
    List<SkuStock> queryAll(SkuStock skuStock);
    
    /**
     * 新增数据
     *
     * @param skuStock 实例对象
     * @return 影响行数
     */
    int insert(SkuStock skuStock);
    
    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SkuStock> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SkuStock> entities);
    
    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SkuStock> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<SkuStock> entities);
    
    /**
     * 修改数据
     *
     * @param skuStock 实例对象
     * @return 影响行数
     */
    int update(SkuStock skuStock);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Object id);
    
}