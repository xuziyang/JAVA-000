package com.xzy.mall.service;

import com.xzy.mall.entity.ProductCategory;

import java.util.List;

/**
 * 商品分类表(ProductCategory)表服务接口
 *
 * @author makejava
 * @since 2020-12-03 09:13:12
 */
public interface ProductCategoryService {
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ProductCategory queryById(Object id);
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<ProductCategory> queryAllByLimit(int offset, int limit);
    
    /**
     * 新增数据
     *
     * @param productCategory 实例对象
     * @return 实例对象
     */
    ProductCategory insert(ProductCategory productCategory);
    
    /**
     * 修改数据
     *
     * @param productCategory 实例对象
     * @return 实例对象
     */
    ProductCategory update(ProductCategory productCategory);
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Object id);
    
}