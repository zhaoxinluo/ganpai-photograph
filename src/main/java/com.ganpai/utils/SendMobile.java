package com.ganpai.utils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
@Component
public class SendMobile {

    @Value("${send.mobile.uid}")
    private String uid;
    @Value("${send.mobile.key}")
    private String key;

    public String sendMobile(String targetMobile,String validCode) throws IOException,Exception{
        HttpClient client = new HttpClient();
        PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
        post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//在头文件中设置转码
        NameValuePair[] data ={ new NameValuePair("Uid", uid),new NameValuePair("Key", key),new NameValuePair("smsMob",targetMobile),new NameValuePair("smsText","欢迎使用感拍网,您的短信验证码是"+validCode+",10分钟内有效")};
        post.setRequestBody(data);

        client.executeMethod(post);
        Header[] headers = post.getResponseHeaders();
        int statusCode = post.getStatusCode();
        System.out.println("statusCode:"+statusCode);
        for(Header h : headers)
        {
            System.out.println(h.toString());
        }
        String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
        System.out.println(result);


        post.releaseConnection();

        return result;
    }


    public static void main(String [] args){
        System.out.println((int)((Math.random()*9+1)*100000));
    }
}
