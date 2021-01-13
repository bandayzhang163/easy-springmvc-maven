package com.banday.app.coupon.service;

import com.banday.app.coupon.entity.CouponUser;
import com.banday.app.coupon.vo.UserCouponVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author banday
 * @since 2021-01-13
 */
public interface ICouponUserService extends IService<CouponUser> {
    List<UserCouponVO> listUserCoupon();
}
