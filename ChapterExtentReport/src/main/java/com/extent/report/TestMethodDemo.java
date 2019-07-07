/*
 * @Author:liuhting
 * @ClassName:TestMethodDemo
 * @Description:TestNG断言和日志
 */
package com.extent.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestMethodDemo {

    @Test
    public void demo1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void demo2(){
        Assert.assertEquals(1,1);
    }


    @Test
    public void demo3(){
        Assert.assertEquals("aaa","aaa");
    }

    @Test
    public void logDemo(){
        Reporter.log("只是我们自己写的日志");
        throw new RuntimeException("这是我们自己运行时的异常");

    }
}
