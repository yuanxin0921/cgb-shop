package com.andy.cgbshopbasicoauth2.support.code;

/**
 * @author yuit
 * @date 2018/10/19 17:42
 *
 */
public interface VerificationCodeGenerator<O,T> {

    /**
     * 生成验证码
     * @return
     */
    VerificationCode<O> generator(T key) throws Exception;

}
