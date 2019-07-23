/*
 * @Author:liuhting
 * @ClassName:TestConfig
 * @Description:定义一个变量，使用static修饰，可以不用new一个对象，而直接使用 类名.变量名 进行调用
 */
package com.course.config;


import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestConfig {

    //登录接口url
    public static  String loginUrl;
    //更新用户信息接口url
    public static String updateUserInfoUrl;
    //获取用户列表接口url
    public static  String getUserInfoUrl;
    //获取用户信息接口url
    public static String getUserListUrl;
    //添加用户信息url
    public static String addUserUrl;

    //用来存储cookie信息的变量
    public static CookieStore store;
    //声明http客户端
    public static DefaultHttpClient defaultHttpClient;
}
