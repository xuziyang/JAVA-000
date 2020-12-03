package com.xzy.mall.controller;

import com.xzy.mall.entity.Order;
import com.xzy.mall.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单表(Order)表控制层
 *
 * @author makejava
 * @since 2020-12-03 09:13:08
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Object id) {
        return this.orderService.queryById(id);
    }
    
}