/*
 * @Author:liuhting
 * @ClassName:MyHttpClient
 * @Description:
 */
package com.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test() throws IOException {
        //定义一个存放结果的变量
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        //执行方法
        HttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

    }
}
