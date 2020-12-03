package com.xzy.mall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品表(Product)实体类
 *
 * @author makejava
 * @since 2020-12-03 14:59:34
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -90027710961382888L;
    
    private Long id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 图片
     */
    private String pic;
    /**
     * 货号
     */
    private String productSn;
    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
    /**
     * 上架状态：0->下架；1->上架
     */
    private Integer publishStatus;
    /**
     * 审核状态：0->未审核；1->审核通过
     */
    private Integer verifyStatus;
    /**
     * 排序
     */
    private Object sort;
    /**
     * 价格
     */
    private Long price;
    /**
     * 商品描述
     */
    private String description;
    /**
     * 市场价
     */
    private Long originalPrice;
    /**
     * 备注
     */
    private String note;
    /**
     * 画册图片，连产品图片限制为5张，以逗号分割
     */
    private String albumPics;
    
    private Date createTime;
    
    private Date updateTime;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPic() {
        return pic;
    }
    
    public void setPic(String pic) {
        this.pic = pic;
    }
    
    public String getProductSn() {
        return productSn;
    }
    
    public void setProductSn(String productSn) {
        this.productSn = productSn;
    }
    
    public Integer getDeleteStatus() {
        return deleteStatus;
    }
    
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    
    public Integer getPublishStatus() {
        return publishStatus;
    }
    
    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }
    
    public Integer getVerifyStatus() {
        return verifyStatus;
    }
    
    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }
    
    public Object getSort() {
        return sort;
    }
    
    public void setSort(Object sort) {
        this.sort = sort;
    }
    
    public Long getPrice() {
        return price;
    }
    
    public void setPrice(Long price) {
        this.price = price;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getOriginalPrice() {
        return originalPrice;
    }
    
    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public String getAlbumPics() {
        return albumPics;
    }
    
    public void setAlbumPics(String albumPics) {
        this.albumPics = albumPics;
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