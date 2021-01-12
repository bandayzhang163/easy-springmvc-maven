package com.banday.app.coupon.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author banday
 * @since 2021-01-12
 */
public class Coupon implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 优惠券名称
     */
    private String name;

    /**
     * 优惠券类型
     */
    private Boolean type;

    /**
     * 使用开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    /**
     * 使用结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    /**
     * 使用大于金额：如果int存储价格，要放到缩小100倍
     */
    private BigDecimal biggerAmount;

    /**
     * 使用优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 使用减少折扣
     */
    private BigDecimal discount;

    /**
     * 库存数量
     */
    private Integer stock;

    /**
     * 被领取数量
     */
    private Integer gettedNum;

    /**
     * 0默认启用，1不启用
     */
    private Boolean enable;

    /**
     * 发布商家的id 
     */
    private Long userId;

    /**
     * 0为默认未删除，1为删除
     */
    private Boolean isDelete;

    /**
     * 创建时间 
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public BigDecimal getBiggerAmount() {
        return biggerAmount;
    }

    public void setBiggerAmount(BigDecimal biggerAmount) {
        this.biggerAmount = biggerAmount;
    }
    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }
    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }
    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    public Integer getGettedNum() {
        return gettedNum;
    }

    public void setGettedNum(Integer gettedNum) {
        this.gettedNum = gettedNum;
    }
    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return "Coupon{" +
            "name=" + name +
            ", type=" + type +
            ", startTime=" + startTime +
            ", endTime=" + endTime +
            ", biggerAmount=" + biggerAmount +
            ", discountAmount=" + discountAmount +
            ", discount=" + discount +
            ", stock=" + stock +
            ", gettedNum=" + gettedNum +
            ", enable=" + enable +
            ", userId=" + userId +
            ", isDelete=" + isDelete +
            ", createdTime=" + createdTime +
            ", updatedTime=" + updatedTime +
        "}";
    }
}
