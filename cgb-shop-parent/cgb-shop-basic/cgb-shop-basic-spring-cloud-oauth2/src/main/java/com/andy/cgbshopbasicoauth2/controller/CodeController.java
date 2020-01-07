package com.andy.cgbshopbasicoauth2.controller;

import com.andy.cgbshopbasicoauth2.response.HttpResponse;
import com.andy.cgbshopbasicoauth2.response.SimpleResponse;
import com.andy.cgbshopbasicoauth2.support.BootSecurityProperties;
import com.andy.cgbshopbasicoauth2.support.DefaultBeanName;
import com.andy.cgbshopbasicoauth2.support.code.VerificationCode;
import com.andy.cgbshopbasicoauth2.support.code.VerificationCodeGenerator;
import com.andy.cgbshopbasicoauth2.support.code.picture.DefaultPictureCodeGenerator;
import com.andy.cgbshopbasicoauth2.support.code.sms.DefaultSmsCodeGenerator;
import com.andy.cgbshopbasicoauth2.support.properities.CodeStoreType;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author yuit
 * @date 2019/11/27 9:27
 **/
@Controller
@RequestMapping("${boot.oauth.code-path:/auth/code}")
public class CodeController {


    private BootSecurityProperties properties;
    private Map<String, VerificationCodeGenerator> codeGenerators;

    public CodeController(BootSecurityProperties properties,  Map<String, VerificationCodeGenerator> codeGenerators) {
        this.properties = properties;
        this.codeGenerators = codeGenerators;
    }

    /**
     *
     * @param request  request
     * @param type sms/picture
     * @throws Exception ex
     */
    @RequestMapping()
    @ResponseBody
    public SimpleResponse<Map<String,Object>> codeGenerateJson(HttpServletRequest request, @RequestParam("type") String type) throws Exception {

        String tmp = type.trim();
        Map<String,Object> responseBoy= new HashMap<>();

        if (tmp.equals("picture")) {

            String key = this.properties.getBaseLogin().getPictureCodeParameterName();

            if (this.properties.getCodeStoreType()== CodeStoreType.redis){
                key = UUID.randomUUID().toString();
            }

            VerificationCode<BufferedImage> pCode = ((DefaultPictureCodeGenerator)this.codeGenerators.get(DefaultBeanName.DEFAULT_PICTURE_CODE_GENERATOR_BEAN))
                    .generator(key);

            ByteArrayOutputStream out= new ByteArrayOutputStream();

            ImageIO.write(pCode.getContent(),"png",out);

            byte[] bts =  out.toByteArray();

            String base64_code = Base64.toBase64String(bts);
            // 删除 \n \r
            base64_code = base64_code.replaceAll("\n","").replace("\r","");

            responseBoy.put("value","data:image/png;base64,"+base64_code);
            responseBoy.put("key",key);
        } else if (tmp.equals("sms")) {

            String key = request.getParameter("mobile");

            VerificationCode<String> sCode = ((DefaultSmsCodeGenerator)this.codeGenerators.get(DefaultBeanName.DEFAULT_SMS_CODE_GENERATOR_BEAN))
                    .generator(key);
            responseBoy.put("value",sCode.getContent());
            responseBoy.put("key",key);
            responseBoy.put("expire",sCode.getExpirationTime());
        }

        return HttpResponse.successSimpleResponse(responseBoy);
    }

}
