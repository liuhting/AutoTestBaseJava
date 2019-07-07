package com.course.testng;

import org.testng.annotations.*;

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

    public void testCase2(){
        System.out.println("第二个测试用例");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass这是在类运行之前运行的");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass这是在类运行之后运行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite测试套件");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite测试套件");

    }
}
