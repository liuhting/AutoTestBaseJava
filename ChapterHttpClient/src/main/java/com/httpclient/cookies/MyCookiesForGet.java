/*
 * @Author:liuhting
 * @ClassName:MyCookiesForGet
 * @Description:
 *              1.通过配置文件的方式执行测试代码
 *              2.有关cookie信息的获取和访问请求（get和post方式）
 */
package com.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    //在测试方法之前，加载配置文件
    @BeforeTest
    public void beforeTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url  = bundle.getString("test.url");
    }

    /*
     * @MethodName:testGetCookies
     * @Description:获取请求返回值里面携带的cookie信息
     * @23:14 2019/7/11
     * @Param:[]
     * @Return:void
    */
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
     * @MethodName:testGetWithCookie
     * @Description:使用从上个请求里面拿到的cookies信息访问get请求
     * @23:29 2019/7/11
     * @Param:[]
     * @Return:void
    */
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookie() throws IOException {
        String uri = bundle.getString("test.get.with.cookie");
        String url = this.url+uri;
        HttpGet get = new HttpGet(url);
        DefaultHttpClient client = new DefaultHttpClient();
        //设置cookie信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);
        
        //获取相应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);
        if (statusCode ==200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }


    }
}
