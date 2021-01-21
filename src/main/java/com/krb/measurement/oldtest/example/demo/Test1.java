package com.krb.measurement.oldtest.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import javax.annotation.Resource;
import java.io.IOException;
import java.nio.charset.Charset;

@Slf4j
@RestController
@ResponseBody
public class Test1 {
    private static final String urlEncoding="UTF-8";
    private static final String contentType="application/json";
    public static String baiRongHttp(String url, String sign,String requestParams) {
        String test = requestParams;
        String baiRongResponse="";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        post.setHeader("app","syt");
        post.setHeader("requestNo","SYT-");
        post.setHeader("sign",sign);
        post.setHeader("Content-Type",contentType);
        StringEntity entity = new StringEntity(test, Charset.forName(urlEncoding));
        entity.setContentEncoding(urlEncoding);
        entity.setContentType(contentType);
        post.setEntity(entity);

        try {
            HttpResponse response = client.execute(post);
            baiRongResponse= EntityUtils.toString(response.getEntity());

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baiRongResponse;
    }



}
