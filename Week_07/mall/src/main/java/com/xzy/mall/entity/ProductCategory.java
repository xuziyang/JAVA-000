package com.xzy.mall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品分类表(ProductCategory)实体类
 *
 * @author makejava
 * @since 2020-12-03 14:59:37
 */
public class ProductCategory implements Serializable {
    private static final long serialVersionUID = -60870064844163412L;
    
    private Long id;
    /**
     * 上级分类的编号：0表示一级分类
     */
    private Long parentId;
    /**
     * 名称
     */
    private String name;
    /**
     * 分类级别：0->1级；1->2级
     */
    private Integer level;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 描述
     */
    private String description;
    
    private Date createTime;
    
    private Date updateTime;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getParentId() {
        return parentId;
    }
    
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getLevel() {
        return level;
    }
    
    public void setLevel(Integer level) {
        this.level = level;
    }
    
    public Integer getSort() {
        return sort;
    }
    
    public void setSort(Integer sort) {
        this.sort = sort;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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