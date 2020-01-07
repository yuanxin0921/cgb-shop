package com.andy.cgbshopbasicoauth2.service.impl;

import com.andy.cgbshopbasicoauth2.entity.User;
import com.andy.cgbshopbasicoauth2.mapper.UserMapper;
import com.andy.cgbshopbasicoauth2.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author yuit
 * @date  2018/10/9  16:56
 *
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public User findByUserName(String userName) {
        return this.baseMapper.findByUserName(userName);
    }

    @Override
    public User findUserByMobile(String mobile) {
        return this.baseMapper.findUserByMobile(mobile);
    }


}
