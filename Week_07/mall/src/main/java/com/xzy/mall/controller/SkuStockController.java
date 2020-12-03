package com.xzy.mall.controller;

import com.xzy.mall.entity.SkuStock;
import com.xzy.mall.service.SkuStockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * sku表(SkuStock)表控制层
 *
 * @author makejava
 * @since 2020-12-03 09:13:13
 */
@RestController
@RequestMapping("skuStock")
public class SkuStockController {
    /**
     * 服务对象
     */
    @Resource
    private SkuStockService skuStockService;
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public SkuStock selectOne(Object id) {
        return this.skuStockService.queryById(id);
    }
    
}