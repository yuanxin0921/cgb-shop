package com.andy.cgbshopbasicoauth2.mapper;

import com.andy.cgbshopbasicoauth2.entity.Client;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author yuit
 * @date 2018/10/16  10:02
 *
 **/
@Repository
public interface ClientMapper extends BaseMapper<Client> {


    @Select("select * from clients where clientId=#{id}")
    Client findClientByClientId(@Param("id") String clientId);

}
