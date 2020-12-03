package com.xzy.mall.entity;

import java.util.List;

public class OrderWrapper {
    private Order order;
    private List<OrderItem> orderItems;
    
    public OrderWrapper(Order order, List<OrderItem> orderItems) {
        this.order = order;
        this.orderItems = orderItems;
    }
    
    public Order getOrder() {
        return order;
    }
    
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }
}
