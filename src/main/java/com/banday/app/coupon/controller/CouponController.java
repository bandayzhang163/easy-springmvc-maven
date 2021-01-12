package com.banday.app.coupon.controller;


import com.banday.app.coupon.entity.Coupon;
import com.banday.app.coupon.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author banday
 * @since 2021-01-12
 */
@Controller
@RequestMapping("/coupon")
public class CouponController {
    @Resource
    ICouponService couponService;

    /**
     * todo: 添加数据乱码
     * todo: 参数未校验
     * todo: 异常未统一处理
     * todo: mp没有id
     * @param coupon
     * @return
     */
    @PostMapping
    public ResponseEntity<String> addCoupon(@RequestBody Coupon coupon){
        //模拟登陆用户
        coupon.setUserId(1L);
        coupon.setCreatedTime(LocalDateTime.now());
        System.out.println(coupon);
        boolean save = couponService.save(coupon);
        return ResponseEntity.ok(save?"ok":"not ok");
    }

    @PutMapping
    public ResponseEntity<String> updateCoupon(@RequestBody Coupon coupon){
        couponService.saveOrUpdate(coupon);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable int id){
        couponService.removeById(id);
        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> listCoupon(){
        List<Coupon> coupons = couponService.list();
        return ResponseEntity.ok(coupons);
    }
}
