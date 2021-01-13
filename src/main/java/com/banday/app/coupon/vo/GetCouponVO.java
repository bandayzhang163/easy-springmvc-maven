package com.banday.app.coupon.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCouponVO {
    /**
     * 优惠券id
     */
    private Long id;
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
     * 发布商家的id
     */
    private Long userId;

    /**
     * 是否已领取
     */
    private Boolean isGetted;

    /**
     * 库存数量
     */
    private Integer stock;
}
