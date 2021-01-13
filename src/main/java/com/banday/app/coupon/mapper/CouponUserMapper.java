package com.banday.app.coupon.mapper;

import com.banday.app.coupon.entity.CouponUser;
import com.banday.app.coupon.vo.UserCouponVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author banday
 * @since 2021-01-13
 */
public interface CouponUserMapper extends BaseMapper<CouponUser> {
    List<UserCouponVO> listUserCoupon();
}
