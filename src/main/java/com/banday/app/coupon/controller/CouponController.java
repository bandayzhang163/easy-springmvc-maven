package com.banday.app.coupon.controller;


import com.banday.app.coupon.entity.Coupon;
import com.banday.app.coupon.service.ICouponService;
import com.banday.app.coupon.vo.R;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Resource
    ICouponService couponService;

    /**
     * 添加优惠券
     * todo:使用dto减少controller中对实体类的处理
     * todo: 自定义返回结果
     *
     */
    @PostMapping
    public R addCoupon(@RequestBody @Validated Coupon coupon){
        //模拟登陆用户
        coupon.setUserId(1L);
        coupon.setCreatedTime(LocalDateTime.now());
        System.out.println(coupon);
        boolean b = couponService.save(coupon);
        return b?R.ok():R.error();
    }

    /**
     * 更新优惠券
     */
    @PutMapping
    public R updateCoupon(@RequestBody Coupon coupon){
        coupon.setUpdatedTime(LocalDateTime.now());
        boolean b = couponService.saveOrUpdate(coupon);
        return b?R.ok():R.error();
    }

    /**
     * 删除优惠券
     * @param ids 要删除id的集合
     */
    @DeleteMapping
    public R deleteCoupon(@RequestBody Integer[] ids){
        List<Coupon> coupons = new ArrayList<>();
        for (Integer id : ids) {
            Coupon coupon = new Coupon();
            coupon.setId(id.longValue());
            coupon.setUpdatedTime(LocalDateTime.now());
            coupon.setIsDelete(true);
            coupons.add(coupon);
        }
        boolean b = couponService.updateBatchById(coupons);
        return b?R.ok():R.error();
    }

    /**
     * 优惠券所有数据列表
     */
    @GetMapping
    public R listCoupon(){
        QueryWrapper<Coupon> wrapper = new QueryWrapper<>();
        wrapper.eq("is_delete",0);
        List<Coupon> coupons = couponService.list(wrapper);
        return R.ok(coupons);
    }

    /**
     * 优惠券分页列表
     */
    @GetMapping("/{page}/{size}")
    public R pageCoupon(@PathVariable Long page,@PathVariable Long size){
        QueryWrapper<Coupon> wrapper = new QueryWrapper<>();
        wrapper.eq("is_delete",0);
        Page<Coupon> filter = new Page<>(page,size);
        Page<Coupon> pageObj = couponService.page(filter, wrapper);
        return R.ok(pageObj.getRecords(),pageObj.getTotal());
    }

    /**
     * 批量更改优惠券启用状态
     * @param ids 更改id的数组
     * @param enable 0或1，表示启用还是关闭
     */
    @PutMapping("/batch/{enable}")
    public R updateBatchCoupon(@RequestBody Integer[] ids,@PathVariable int enable){
        List<Coupon> coupons = new ArrayList<>();
        for (Integer id : ids) {
            Coupon coupon = new Coupon();
            coupon.setId(id.longValue());
            coupon.setUpdatedTime(LocalDateTime.now());
            coupon.setEnable(enable == 1);
            coupons.add(coupon);
        }
        boolean b = couponService.updateBatchById(coupons);
        return b?R.ok():R.error();
    }
}
