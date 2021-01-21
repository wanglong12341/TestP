package com.krb.measurement.oldtest.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.krb.measurement.dto.CallBackMessage;
import com.krb.measurement.dto.TestThird;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@ResponseBody
@CrossOrigin
public class AnthoerController extends Dependencies {


    @RequestMapping(value = "/SJHD")
    @ResponseBody
    public CallBackMessage SJHD(@RequestBody TestThird testThird){
        CallBackMessage message = new CallBackMessage();
//        req.getParameterNames()
        String sql = "insert into  reslog (id,order_id,res) VALUES  (null,'"+testThird.getOrderId()+"','"+testThird.getData()+"')";
        try{
            insert(sql);
        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
//        try {
//            BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
//            StringBuffer sb=new StringBuffer();
//            String s=null;
//            while((s=br.readLine())!=null){
//                sb.append(s);
//            }
//            JSONObject jsonObject = JSONObject.parseObject(sb.toString());
//            String name = jsonObject.getString("data");
//            System.out.println(name);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        message.setCode(200);
        return message;
    }
}
