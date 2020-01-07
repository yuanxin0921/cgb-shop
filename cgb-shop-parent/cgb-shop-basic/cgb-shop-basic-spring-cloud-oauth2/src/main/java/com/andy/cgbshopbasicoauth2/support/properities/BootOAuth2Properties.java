package com.andy.cgbshopbasicoauth2.support.properities;

import com.andy.cgbshopbasicoauth2.support.common.TokenStoreType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yuit
 * @date 2019/11/26 12:19
 **/
@Getter
@Setter
public class BootOAuth2Properties {
    /**
     * 定义token存储类型
     */
    private TokenStoreType tokenStoreType = TokenStoreType.memory;

    private String tokenSigningKey = "OAUTHBOOT@IUY09&098#UIOKNJJ-YUIT.CLUB";
}
