package com.xzy.mall.controller;

import com.xzy.mall.entity.Product;
import com.xzy.mall.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品表(Product)表控制层
 *
 * @author makejava
 * @since 2020-12-03 09:13:12
 */
@RestController
@RequestMapping("product")
public class ProductController {
    /**
     * 服务对象
     */
    @Resource
    private ProductService productService;
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Product selectOne(Object id) {
        return this.productService.queryById(id);
    }
    
}