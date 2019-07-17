/*
 * @Author:liuhting
 * @ClassName:MyCookieForPost
 * @Description:携带cookies信息访问post请求
 */
package com.httpclient.cookies;


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookieForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    //在测试方法之前，加载配置文件
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");

    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //从配置文件获取uri
        String uri = bundle.getString("getCookies.uri");
        //获取完整的路径
        String testUri= this.url+uri;
        HttpGet get = new HttpGet(testUri);

        //测试逻辑代码
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //获取cookie信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();
        for(Cookie cookie:cookieList){
            String  name= cookie.getName();
            String value= cookie.getValue();
            System.out.println("cookie name ="+name+";cookie value="+value);
        }

    }

    /*
     * @MethodName:testPostWithCookies
     * @Description:使用从上个请求里面拿到的cookies信息访问post请求
     * @21:35 2019/7/16
     * @Param:[]
     * @Return:void
    */        
    @Test(dependsOnMethods = "testGetCookies")
    public void testPostWithCookies() throws IOException {
        String uri = bundle.getString("test.post.with.cookie");
        //拼接得到最终的完整的测试地址
        String testUrl = this.url+uri;
        //声明一个方法---Post方法
        HttpPost post = new HttpPost(testUrl);
        //声明一个client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //添加参数----Json格式的
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        //设置请求头信息
        post.addHeader("content-type","application/json");
        //将参数添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象来进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);

        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理结果，就是判断返回结果是否符合预期
            //将返回的响应结果对象转换为json字符串
        JSONObject resultJson = new JSONObject(result);
        //获得结果值
        String success = (String)resultJson.get("huhansan");
        Assert.assertEquals("success",success);
        String status =(String)resultJson.get("status");
        Assert.assertEquals("1",status);




    }
}
