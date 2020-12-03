package com.xzy.mall.service.impl;

import com.xzy.mall.dao.SkuStockDao;
import com.xzy.mall.entity.SkuStock;
import com.xzy.mall.service.SkuStockService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * sku表(SkuStock)表服务实现类
 *
 * @author makejava
 * @since 2020-12-03 09:13:13
 */
@Service("skuStockService")
public class SkuStockServiceImpl implements SkuStockService {
    @Resource
    private SkuStockDao skuStockDao;
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SkuStock queryById(Object id) {
        return this.skuStockDao.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SkuStock> queryAllByLimit(int offset, int limit) {
        return this.skuStockDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 新增数据
     *
     * @param skuStock 实例对象
     * @return 实例对象
     */
    @Override
    public SkuStock insert(SkuStock skuStock) {
        this.skuStockDao.insert(skuStock);
        return skuStock;
    }
    
    /**
     * 修改数据
     *
     * @param skuStock 实例对象
     * @return 实例对象
     */
    @Override
    public SkuStock update(SkuStock skuStock) {
        this.skuStockDao.update(skuStock);
        return this.queryById(skuStock.getId());
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.skuStockDao.deleteById(id) > 0;
    }
}