package com.andy.cgbshopbasicoauth2.mapper;

import com.andy.cgbshopbasicoauth2.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author yuit
 * @date 2018/10/9  15:44
 *
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {


    User findByUserName(String username);

    User findUserByMobile(String mobile);


}
