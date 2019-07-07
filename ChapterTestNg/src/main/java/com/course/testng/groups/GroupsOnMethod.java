/*
 * @Author:liuhting
 * @ClassName:GroupsOnMethod
 * @Description:组测试中的方法分组测试
 */
package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupsOnMethod {

    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端的测试方法111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端的测试方法2222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是服务端的测试方法33333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是服务端的测试方法444444");
    }

    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组方法运行之前运行的");
    }

    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组方法运行之后运行的");
        System.out.println();
    }

    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组方法运行之前运行的");
    }

    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户端组方法运行之后运行的");
        System.out.println();
    }
}
