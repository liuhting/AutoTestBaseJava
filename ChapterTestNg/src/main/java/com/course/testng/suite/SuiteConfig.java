/*
 * @Author:liuhting
 * @ClassName:SuiteConfig
 * @Description:
 */
package com.course.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite运行");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite运行");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest这是在测试案例之前运行的");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest在测试案例之后运行的");
    }
}
