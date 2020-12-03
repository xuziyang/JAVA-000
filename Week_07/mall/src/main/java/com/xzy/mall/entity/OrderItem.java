package com.xzy.mall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单条目表(OrderItem)实体类
 *
 * @author makejava
 * @since 2020-12-03 14:59:31
 */
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -24410416828682133L;
    
    private Long id;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 订单编号
     */
    private String orderSn;
    /**
     * 商品id
     */
    private Long productId;
    /**
     * 商品图片
     */
    private String productPic;
    /**
     * 商品名称
     */
    private String productName;
    /**
     * 商品条码
     */
    private String productSn;
    /**
     * 销售价格
     */
    private Long productPrice;
    /**
     * 购买数量
     */
    private Object productQuantity;
    /**
     * 商品sku编号
     */
    private Long productSkuId;
    
    private Date createTime;
    
    private Date updateTime;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getOrderId() {
        return orderId;
    }
    
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    public String getOrderSn() {
        return orderSn;
    }
    
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
    
    public Long getProductId() {
        return productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public String getProductPic() {
        return productPic;
    }
    
    public void setProductPic(String productPic) {
        this.productPic = productPic;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public String getProductSn() {
        return productSn;
    }
    
    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }
    
    public Long getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }
    
    public Object getProductQuantity() {
        return productQuantity;
    }
    
    public void setProductQuantity(Object productQuantity) {
        this.productQuantity = productQuantity;
    }
    
    public Long getProductSkuId() {
        return productSkuId;
    }
    
    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
}