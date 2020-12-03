package com.xzy.mall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * sku表(SkuStock)实体类
 *
 * @author makejava
 * @since 2020-12-03 14:59:39
 */
public class SkuStock implements Serializable {
    private static final long serialVersionUID = 149018297062722538L;
    
    private Long id;
    /**
     * 商品id
     */
    private Long productId;
    /**
     * sku编码
     */
    private String skuCode;
    /**
     * 价格
     */
    private Long price;
    /**
     * 库存
     */
    private Object stock;
    /**
     * 规格属性1
     */
    private String sp1;
    /**
     * 规格属性2
     */
    private String sp2;
    /**
     * 规格属性3
     */
    private String sp3;
    /**
     * 展示图片
     */
    private String pic;
    /**
     * 销量
     */
    private Object sale;
    
    private Date createTime;
    
    private Date updateTime;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getProductId() {
        return productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    public String getSkuCode() {
        return skuCode;
    }
    
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }
    
    public Long getPrice() {
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
    
    public Object getStock() {
        return stock;
    }
    
    public void setStock(Object stock) {
        this.stock = stock;
    }
    
    public String getSp1() {
        return sp1;
    }
    
    public void setSp1(String sp1) {
        this.sp1 = sp1;
    }
    
    public String getSp2() {
        return sp2;
    }
    
    public void setSp2(String sp2) {
        this.sp2 = sp2;
    }
    
    public String getSp3() {
        return sp3;
    }
    
    public void setSp3(String sp3) {
        this.sp3 = sp3;
    }
    
    public String getPic() {
        return pic;
    }
    
    public void setPic(String pic) {
        this.pic = pic;
    }
    
    public Object getSale() {
        return sale;
    }
    
    public void setSale(Object sale) {
        this.sale = sale;
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