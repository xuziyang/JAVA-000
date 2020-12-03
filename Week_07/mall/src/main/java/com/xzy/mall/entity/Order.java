package com.xzy.mall.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单表(Order)实体类
 *
 * @author makejava
 * @since 2020-12-03 14:59:28
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 513719240981887099L;
    /**
     * 订单id
     */
    private Long id;
    /**
     * 订单编号
     */
    private String orderSn;
    /**
     * 用户帐号
     */
    private Long userId;
    /**
     * 订单总金额
     */
    private Long totalAmount;
    /**
     * 应付金额（实际支付金额）
     */
    private Long payAmount;
    /**
     * 运费金额
     */
    private Long freightAmount;
    /**
     * 支付方式：0->未支付；1->支付宝；2->微信
     */
    private Integer payType;
    /**
     * 订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单
     */
    private Integer status;
    /**
     * 订单类型：0->正常订单；1->秒杀订单
     */
    private Integer orderType;
    /**
     * 物流公司(配送方式)
     */
    private String deliveryCompany;
    /**
     * 物流单号
     */
    private String deliverySn;
    /**
     * 自动确认时间（天）
     */
    private Integer autoConfirmDay;
    /**
     * 收货人姓名
     */
    private String receiverName;
    /**
     * 收货人电话
     */
    private String receiverPhone;
    /**
     * 收货人邮编
     */
    private String receiverPostCode;
    /**
     * 省份/直辖市
     */
    private String receiverProvince;
    /**
     * 城市
     */
    private String receiverCity;
    /**
     * 区
     */
    private String receiverRegion;
    /**
     * 详细地址
     */
    private String receiverDetailAddress;
    /**
     * 订单备注
     */
    private String note;
    /**
     * 确认收货状态：0->未确认；1->已确认
     */
    private Integer confirmStatus;
    /**
     * 删除状态：0->未删除；1->已删除
     */
    private Integer deleteStatus;
    /**
     * 提交时间
     */
    private Date createTime;
    /**
     * 支付时间
     */
    private Date paymentTime;
    /**
     * 发货时间
     */
    private Date deliveryTime;
    /**
     * 确认收货时间
     */
    private Date receiveTime;
    /**
     * 评价时间
     */
    private Date commentTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getOrderSn() {
        return orderSn;
    }
    
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }
    
    public Long getUserId() {
        return userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    public Long getTotalAmount() {
        return totalAmount;
    }
    
    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    public Long getPayAmount() {
        return payAmount;
    }
    
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }
    
    public Long getFreightAmount() {
        return freightAmount;
    }
    
    public void setFreightAmount(Long freightAmount) {
        this.freightAmount = freightAmount;
    }
    
    public Integer getPayType() {
        return payType;
    }
    
    public void setPayType(Integer payType) {
        this.payType = payType;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public Integer getOrderType() {
        return orderType;
    }
    
    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }
    
    public String getDeliveryCompany() {
        return deliveryCompany;
    }
    
    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }
    
    public String getDeliverySn() {
        return deliverySn;
    }
    
    public void setDeliverySn(String deliverySn) {
        this.deliverySn = deliverySn;
    }
    
    public Integer getAutoConfirmDay() {
        return autoConfirmDay;
    }
    
    public void setAutoConfirmDay(Integer autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }
    
    public String getReceiverName() {
        return receiverName;
    }
    
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }
    
    public String getReceiverPhone() {
        return receiverPhone;
    }
    
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }
    
    public String getReceiverPostCode() {
        return receiverPostCode;
    }
    
    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }
    
    public String getReceiverProvince() {
        return receiverProvince;
    }
    
    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }
    
    public String getReceiverCity() {
        return receiverCity;
    }
    
    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }
    
    public String getReceiverRegion() {
        return receiverRegion;
    }
    
    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }
    
    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }
    
    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }
    
    public String getNote() {
        return note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    
    public Integer getConfirmStatus() {
        return confirmStatus;
    }
    
    public void setConfirmStatus(Integer confirmStatus) {
        this.confirmStatus = confirmStatus;
    }
    
    public Integer getDeleteStatus() {
        return deleteStatus;
    }
    
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    public Date getPaymentTime() {
        return paymentTime;
    }
    
    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
    
    public Date getDeliveryTime() {
        return deliveryTime;
    }
    
    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }
    
    public Date getReceiveTime() {
        return receiveTime;
    }
    
    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }
    
    public Date getCommentTime() {
        return commentTime;
    }
    
    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }
    
    public Date getUpdateTime() {
        return updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
}