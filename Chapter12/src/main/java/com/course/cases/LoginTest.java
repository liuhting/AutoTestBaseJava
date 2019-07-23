/*
 * @Author:liuhting
 * @ClassName:LoginTest
 * @Description:
 */
package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.LoginCase;
import com.course.utils.ConfigFile;
import com.course.utils.DatabaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {
    @BeforeTest(groups = "LoginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.defaultHttpClient = new DefaultHttpClient();
        TestConfig.getUserInfoUrl = ConfigFile.getUrl(InterfaceName.GETUSERINFO);
        TestConfig.getUserListUrl =ConfigFile.getUrl(InterfaceName.GETUSERLIST);
        TestConfig.loginUrl =ConfigFile.getUrl(InterfaceName.LOGIN);
        TestConfig.addUserUrl =ConfigFile.getUrl(InterfaceName.ADDUSER);
        TestConfig.updateUserInfoUrl =ConfigFile.getUrl(InterfaceName.UPDATEUSERINFO);
    }

    @Test(groups = "LoginTrue",description = "用户成功登录接口")
    public void loginTrue() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        LoginCase loginCase= session.selectOne("loginCase",1);
        System.out.println(loginCase.toString());
        System.out.println(TestConfig.loginUrl);

        //写完接口的测试代码
        String result= getResult(loginCase);
        //处理结果，就是判断返回结果是否符合预期
        Assert.assertEquals(loginCase.getExpected(),result);

    }


    private String getResult(LoginCase loginCase) {
        return null;

    }
}
