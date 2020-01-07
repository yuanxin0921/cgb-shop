package com.andy.cgbshopbasicoauth2.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author yuit
 * @date   2018/3/30 20:37
 *
 */
@Getter
@Setter
public class ListResponse<T> extends BaseResponse {

    private long count;
    private List<T> items;

    protected ListResponse(){

    }

}
