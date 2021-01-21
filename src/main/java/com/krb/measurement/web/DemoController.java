package com.krb.measurement.web;

import com.krb.measurement.config.WebConfigProperties;
import com.krb.measurement.dto.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("demo")
@Slf4j
public class DemoController {

    @Autowired
    private WebConfigProperties webConfigProperties;

    @RequestMapping("demo-for-html")
    public String statisticsChart(){
        log.info("[DEMO]这里是一个测试log 内容为{},结果为{}",webConfigProperties.getDatabsurl(),webConfigProperties.getXxxx());
        return "/index";
    }

    @RequestMapping("/demo-for-ajax")
    @ResponseBody
    public AjaxResult getMerchantMap(HttpServletRequest request, HttpServletResponse response){
        try{
            return new AjaxResult("200","SUCCESS","这里写数据");
        } catch(Exception e ){
            return new AjaxResult("500","请求异常");
        }
    }


}
