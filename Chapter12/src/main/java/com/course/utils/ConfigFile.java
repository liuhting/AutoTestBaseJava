/**
 * @Author:liuhting
 * @ClassName:ConfigFile
 * @Description:当前类下面的方法作用：从配置文件中获得url,将基本地址与后面的url拼接，形成最终访问的测试地址
 */
package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle= ResourceBundle.getBundle("application", Locale.CHINA);

    /**
     * @MethodName:getUrl
     * @Description:拼接形成最终的测试地址并返回
     * @15:47 2019/7/23
     * @Param:[name]
     * @Return:java.lang.String
    */
    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri="";
        //最终测试地址
        String testUrl;
        if(name ==InterfaceName.GETUSERLIST){
            uri = bundle.getString("getUserList.uri");
        }
        if (name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }
        if (name == InterfaceName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }
        if (name == InterfaceName.GETUSERINFO)
        {
            uri = bundle.getString("getUserInfo.uri");
        }
        if (name == InterfaceName.ADDUSER){
            uri = bundle.getString("addUser.Info");
        }
        //拼接成最终的测试地址并返回
        testUrl = address + uri;
        return testUrl;

    }

}
