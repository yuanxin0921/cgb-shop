package com.andy.cgbshopservicememberimpl.serviceFeign;

import com.andy.cgbshopserviceapiweixin.service.GetAppService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("cgb-shop-service-weixin-impl")
public interface WeixinAppServiceFeign extends GetAppService {

}
