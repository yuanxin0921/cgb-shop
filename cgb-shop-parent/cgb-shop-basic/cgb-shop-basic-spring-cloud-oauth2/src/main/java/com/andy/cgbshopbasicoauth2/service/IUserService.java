package com.andy.cgbshopbasicoauth2.service;

import com.andy.cgbshopbasicoauth2.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author yuit
 * @date 2018/10/9  16:55
 *
 **/
public interface IUserService  extends IService<User> {

    User findByUserName(String userName);
    User findUserByMobile(String mobile);
}
