package com.xzy.mall.service.impl;

import com.xzy.mall.dao.OrderDao;
import com.xzy.mall.dao.OrderItemDao;
import com.xzy.mall.entity.Order;
import com.xzy.mall.entity.OrderItem;
import com.xzy.mall.entity.OrderWrapper;
import com.xzy.mall.entity.Product;
import com.xzy.mall.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 订单表(Order)表服务实现类
 *
 * @author makejava
 * @since 2020-12-03 09:13:07
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    
    @Resource
    private OrderDao orderDao;
    
    @Resource
    private OrderItemDao orderItemDao;
    
    @Override
    @Transactional
    public void saveOrder(OrderWrapper orderWrapper) {
        this.insert(orderWrapper.getOrder());
        for (OrderItem item : orderWrapper.getOrderItems()) {
            orderItemDao.insert(item);
        }
    }
    
    @Transactional
    @Override
    public void saveOrderBatch(List<OrderWrapper> orderWrappers) {
        List<Order> orders = new ArrayList<>(orderWrappers.size());
        List<OrderItem> items = new ArrayList<>(orderWrappers.size());
        for (OrderWrapper wrapper: orderWrappers) {
            orders.add(wrapper.getOrder());
            items.addAll(wrapper.getOrderItems());
        }
        orderDao.insertBatch(orders);
        orderItemDao.insertBatch(items);
    }
    
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Order queryById(Object id) {
        return this.orderDao.queryById(id);
    }
    
    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Order> queryAllByLimit(int offset, int limit) {
        return this.orderDao.queryAllByLimit(offset, limit);
    }
    
    /**
     * 新增数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order insert(Order order) {
        this.orderDao.insert(order);
        return order;
    }
    
    /**
     * 修改数据
     *
     * @param order 实例对象
     * @return 实例对象
     */
    @Override
    public Order update(Order order) {
        this.orderDao.update(order);
        return this.queryById(order.getId());
    }
    
    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Object id) {
        return this.orderDao.deleteById(id) > 0;
    }
}