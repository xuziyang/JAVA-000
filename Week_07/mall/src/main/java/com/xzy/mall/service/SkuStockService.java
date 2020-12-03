package com.xzy.mall.service;

import com.xzy.mall.entity.SkuStock;

import java.util.List;

/**
 * sku表(SkuStock)表服务接口
 *
 * @author makejava
 * @since 2020-12-03 09:13:13
 */
public interface SkuStockService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SkuStock queryById(Object id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SkuStock> queryAllByLimit(int offset, int limit);
    
    /**
     * 新增数据
     *
     * @param skuStock 实例对象
     * @return 实例对象
     */
    SkuStock insert(SkuStock skuStock);
    
    /**
     * 修改数据
     *
     * @param skuStock 实例对象
     * @return 实例对象
     */
    SkuStock update(SkuStock skuStock);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Object id);
    
}