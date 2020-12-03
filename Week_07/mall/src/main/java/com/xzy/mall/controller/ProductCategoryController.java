package com.xzy.mall.controller;

import com.xzy.mall.entity.ProductCategory;
import com.xzy.mall.service.ProductCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品分类表(ProductCategory)表控制层
 *
 * @author makejava
 * @since 2020-12-03 09:13:13
 */
@RestController
@RequestMapping("productCategory")
public class ProductCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private ProductCategoryService productCategoryService;
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ProductCategory selectOne(Object id) {
        return this.productCategoryService.queryById(id);
    }
    
}