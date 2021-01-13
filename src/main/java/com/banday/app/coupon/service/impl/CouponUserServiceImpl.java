package com.banday.app.coupon.service.impl;

import com.banday.app.coupon.entity.CouponUser;
import com.banday.app.coupon.mapper.CouponUserMapper;
import com.banday.app.coupon.service.ICouponUserService;
import com.banday.app.coupon.vo.UserCouponVO;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author banday
 * @since 2021-01-13
 */
@Service
public class CouponUserServiceImpl extends ServiceImpl<CouponUserMapper, CouponUser> implements ICouponUserService {
    @Autowired
    CouponUserMapper couponUserMapper;

    @Override
    public List<UserCouponVO> listUserCoupon() {
        return couponUserMapper.listUserCoupon();
    }
}
