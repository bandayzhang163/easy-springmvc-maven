package com.banday.app.coupon.service.impl;

import com.banday.app.coupon.entity.User;
import com.banday.app.coupon.mapper.UserMapper;
import com.banday.app.coupon.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author banday
 * @since 2021-01-12
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
