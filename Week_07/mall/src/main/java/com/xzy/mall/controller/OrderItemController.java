package com.xzy.mall.controller;

import com.xzy.mall.entity.OrderItem;
import com.xzy.mall.service.OrderItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单条目表(OrderItem)表控制层
 *
 * @author makejava
 * @since 2020-12-03 09:13:11
 */
@RestController
@RequestMapping("orderItem")
public class OrderItemController {
    /**
     * 服务对象
     */
    @Resource
    private OrderItemService orderItemService;
    
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public OrderItem selectOne(Object id) {
        return this.orderItemService.queryById(id);
    }
    
}