package com.xzy.mall.service;

import com.xzy.mall.entity.*;
import com.xzy.mall.util.OrderIdUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class OrderServiceTest {
    
    private static final int ORDER_SIZE = 1_000;
    
    @Autowired
    private OrderService orderService;
    
    @Autowired
    private SkuStockService skuStockService;
    
    @Autowired
    private ProductService productService;
    
    @Test
    public void insertTest() {
        List<OrderWrapper> wrapperList = genOrders();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < wrapperList.size(); i++) {
            orderService.saveOrder(wrapperList.get(i));
        }
        long duration = System.currentTimeMillis() - startTime;
        System.out.println(duration);
    }
    
    @Test
    public void insertBatchTest() {
        List<OrderWrapper> wrapperList = genOrders();
        long startTime = System.currentTimeMillis();
        orderService.saveOrderBatch(wrapperList);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println(duration);
    }
    
    private List<OrderWrapper> genOrders() {
        List<OrderWrapper> wrapperList = new ArrayList<>(ORDER_SIZE);
        SkuStock skuStock = skuStockService.queryById(1);
        List<SkuStock> skuStocks = new ArrayList<SkuStock>(){{
            add(skuStock);
        }};
        for (int i = 0; i < ORDER_SIZE; i++) {
            OrderWrapper wrapper = createOrder(i % 10, skuStocks);
            wrapperList.add(wrapper);
        }
        return wrapperList;
    }
    
    private Product product = null;
    private OrderWrapper createOrder(long userId, List<SkuStock> skuStockList) {
        Order order = new Order();
        order.setId(OrderIdUtils.nextId());
        order.setOrderSn(generateOrderSn(order));
        order.setAutoConfirmDay(14);
        order.setUserId(userId);
        order.setStatus(1);
        order.setOrderType(0);
        order.setReceiverName("张三");
        order.setReceiverPhone("15711124141");
        order.setReceiverPostCode("071419");
        order.setReceiverProvince("河北");
        order.setReceiverCity("石家庄");
        order.setReceiverRegion("桥西");
        order.setReceiverDetailAddress("xxxxxxxxxxxfsaf");
        order.setConfirmStatus(0);
        order.setDeleteStatus(0);
        Date curDate = new Date();
        order.setCreateTime(curDate);
        order.setUpdateTime(curDate);
        List<OrderItem> orderItems = new ArrayList<>(skuStockList.size());
        long totalAmount = 0L;
        for (SkuStock skuStock: skuStockList) {
            if (product == null) {
                product = productService.queryById(skuStock.getId());
            }
            OrderItem item = new OrderItem();
            item.setId(OrderIdUtils.nextId());
            item.setOrderId(order.getId());
            item.setOrderSn(order.getOrderSn());
            item.setProductId(product.getId());
            item.setProductPic(product.getPic());
            item.setProductName(product.getName());
            item.setProductSn(product.getProductSn());
            item.setProductPrice(product.getPrice());
            item.setProductQuantity(1);
            item.setProductSkuId(skuStock.getId());
            item.setCreateTime(curDate);
            item.setUpdateTime(curDate);
            totalAmount += skuStock.getPrice();
            orderItems.add(item);
        }
        order.setTotalAmount(totalAmount);
        order.setPayAmount(totalAmount);
        order.setFreightAmount(0L);
        return new OrderWrapper(order, orderItems);
    }
    
    //todo
    private String generateOrderSn(Order order) {
        return String.valueOf(order.getId());
    }
}