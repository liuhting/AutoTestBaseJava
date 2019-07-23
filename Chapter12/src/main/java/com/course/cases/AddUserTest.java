/*
 * @Author:liuhting
 * @ClassName:AddUserTest
 * @Description:
 */
package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.AddUserCase;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddUserTest {

    @Test(dependsOnGroups = "LoginTrue",description = "添加用户接口")
    public void addUser() throws IOException {
        //调用DatabaseUtil类的方法，获取session
        SqlSession session= DatabaseUtil.getSqlSession();
        //执行sql语句，传入的值和SQLMapper中的ID匹配
        AddUserCase addUserCase =session.selectOne("addUserCase",1);
        System.out.println(addUserCase.toString());
        System.out.println(TestConfig.addUserUrl);

        //调用方法，获取添加用户信息接口执行的返回值
        String result =getResult(addUserCase);

        //数据校验



    }

    /**
     * @MethodName:getResult
     * @Description:该方法执行自定义开发的添加用户信息的的接口，获取返回值
     * @16:06 2019/7/23
     * @Param:[addUserCase]
     * @Return:java.lang.String
    */
    private String getResult(AddUserCase addUserCase) throws IOException {

        HttpPost post = new HttpPost(TestConfig.addUserUrl);
        //定义一个变量接收参数
        JSONObject param = new JSONObject();
        //将参数传入
        param.put("userName",addUserCase.getUserName());
        param.put("password",addUserCase.getPassword());
        param.put("sex",addUserCase.getSex());
        param.put("age",addUserCase.getAge());
        param.put("permissiom",addUserCase.getPermission());
        param.put("df",addUserCase.getDf());
        //设置请求头信息
        post.setHeader("content-type","application/json");
        //将参数添加到方法里面
        StringEntity entity= new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //设置cookie
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);

        //声明一个对象来存储响应结果
        String result;
        //执行post方法
        HttpResponse response=TestConfig.defaultHttpClient.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        return result;
    }
}
