package com.xzy.mall.service.impl;

import com.xzy.mall.dao.ProductCategoryDao;
import com.xzy.mall.entity.ProductCategory;
import com.xzy.mall.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品分类表(ProductCategory)表服务实现类
 *
 * @author makejava
 * @since 2020-12-03 09:13:12
 */
@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Resource
    private ProductCategoryDao productCategoryDao;
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public ProductCategory queryById(Object id) {
        return this.productCategoryDao.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<ProductCategory> queryAllByLimit(int offset, int limit) {
        return this.productCategoryDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 新增数据
     *
     * @param productCategory 实例对象
     * @return 实例对象
     */
    @Override
    public ProductCategory insert(ProductCategory productCategory) {
        this.productCategoryDao.insert(productCategory);
        return productCategory;
    }
    
    /**
     * 修改数据
     *
     * @param productCategory 实例对象
     * @return 实例对象
     */
    @Override
    public ProductCategory update(ProductCategory productCategory) {
        this.productCategoryDao.update(productCategory);
        return this.queryById(productCategory.getId());
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.productCategoryDao.deleteById(id) > 0;
    }
}