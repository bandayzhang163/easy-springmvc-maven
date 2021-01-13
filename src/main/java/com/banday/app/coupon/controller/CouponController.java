package com.banday.app.coupon.controller;


import com.banday.app.coupon.entity.Coupon;
import com.banday.app.coupon.service.ICouponService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.HashMap;
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
        coupon.setUpdatedTime(LocalDateTime.now());
        couponService.saveOrUpdate(coupon);
        return ResponseEntity.ok("ok");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoupon(@PathVariable Long id){
        Coupon coupon = new Coupon();
        coupon.setId(id);
        coupon.setIsDelete(true);
        coupon.setUpdatedTime(LocalDateTime.now());
        couponService.saveOrUpdate(coupon);
        return ResponseEntity.ok("ok");
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> listCoupon(){
        QueryWrapper<Coupon> wrapper = new QueryWrapper<>();
        wrapper.eq("is_delete",0);
        List<Coupon> coupons = couponService.list(wrapper);
        return ResponseEntity.ok(coupons);
    }

    @GetMapping("/{page}/{size}")
    public ResponseEntity<HashMap<String,Object>> pageCoupon(@PathVariable Long page,@PathVariable Long size){
        QueryWrapper<Coupon> wrapper = new QueryWrapper<>();
        wrapper.eq("is_delete",0);
        Page<Coupon> filter = new Page<>(page,size);
        Page<Coupon> pageObj = couponService.page(filter, wrapper);
        HashMap<String, Object> map = new HashMap<>();
        map.put("current",pageObj.getCurrent());
        map.put("size",pageObj.getSize());
        map.put("total",pageObj.getTotal());
        map.put("records",pageObj.getRecords());
        return ResponseEntity.ok(map);
    }
}
