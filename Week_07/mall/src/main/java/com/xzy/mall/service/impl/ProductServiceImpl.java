package com.xzy.mall.service.impl;

import com.xzy.mall.dao.ProductDao;
import com.xzy.mall.entity.Product;
import com.xzy.mall.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 商品表(Product)表服务实现类
 *
 * @author makejava
 * @since 2020-12-03 09:13:12
 */
@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;
    
    
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Product queryById(Object id) {
        return this.productDao.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Product> queryAllByLimit(int offset, int limit) {
        return this.productDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 新增数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product insert(Product product) {
        this.productDao.insert(product);
        return product;
    }
    
    /**
     * 修改数据
     *
     * @param product 实例对象
     * @return 实例对象
     */
    @Override
    public Product update(Product product) {
        this.productDao.update(product);
        return this.queryById(product.getId());
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.productDao.deleteById(id) > 0;
    }
}