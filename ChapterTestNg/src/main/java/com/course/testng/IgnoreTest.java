/*
 * @Author:liuhting
 * @ClassName:IgnoreTest
 * @Description:忽略测试----使得某些测试方法不执行
 */
package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    @Test
    public void ignore1(){
        System.out.println("ignore1执行");
    }

    /*
     * @MethodName:ignore2
     * @Description:注解的参数enable为false，方法不执行
     * @19:11 2019/7/7
     * @Param:[]
     * @Return:void
    */
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2被忽略，不执行");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 ");
    }
}
