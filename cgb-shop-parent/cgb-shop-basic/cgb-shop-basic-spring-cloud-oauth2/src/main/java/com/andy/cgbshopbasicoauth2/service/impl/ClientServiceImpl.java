package com.andy.cgbshopbasicoauth2.service.impl;

import com.andy.cgbshopbasicoauth2.entity.Client;
import com.andy.cgbshopbasicoauth2.mapper.ClientMapper;
import com.andy.cgbshopbasicoauth2.service.IClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author yuit
 * @date 2018/10/16  10:06
 *
 **/
@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements IClientService {


    @Override
    public Client findClientByClientId(String clientId) {
        return this.baseMapper.findClientByClientId(clientId);
    }
}
