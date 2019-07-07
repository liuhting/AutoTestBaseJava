package com.course.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicAnnotation {
    /*
     * @MethodName:testCase1
     * @Description: @Test---最基本的注解，把方法标注为测试的一部分
     * @18:17 2019/7/7
     * @Param:[]
     * @Return:void
    */        
    @Test
    public  void testCase1(){
        System.out.println("第一个测试用例");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }
}
