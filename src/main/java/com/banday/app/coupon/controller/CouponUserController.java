package com.banday.app.coupon.controller;


import com.banday.app.coupon.entity.Coupon;
import com.banday.app.coupon.entity.CouponUser;
import com.banday.app.coupon.service.ICouponUserService;
import com.banday.app.coupon.vo.UserCouponVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author banday
 * @since 2021-01-13
 */
@Controller
@RequestMapping("/user/coupon")
public class CouponUserController {
    @Resource
    ICouponUserService iCouponUserService;
    /**
     * 用户显示已领取优惠券
     */
    @GetMapping
    public ResponseEntity<List<UserCouponVO>> userCoupons(){
        List<UserCouponVO> listUserCoupon = iCouponUserService.listUserCoupon();
        return ResponseEntity.ok(listUserCoupon);
    }
}
