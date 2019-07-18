/*
 * @Author:liuhting
 * @ClassName:SpGetMethod
 * @Description:使用springboot开发一个 返回cookies信息的get接口
 */
package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
//该注解用于swagger的注释信息
@Api(value="/",description = "这是我的get请求的方法")
public class SpGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    //该注解用于swagger对方法的描述
    @ApiOperation(value="通过这个方法可以获取到cookies信息",httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest  装请求信息的类
        //HttpServletResponse  装响应信息的类
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜您获得Cookies信息";
    }

    /*
     * @MethodName:
     * @Description:要求客户端携带Cookies信息访问
     * 这是一个需要携带Cookies信息才能访问的get请求
     * @13:39 2019/7/18
     * @Param:
     * @Return:
     */
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value="要求客户端携带cookie信息才能访问",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (Objects.isNull(cookies)) {
            return "你必须携带Cookie信息来";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "这是一个需要携带cookie信息才能访问的get请求--成功访问";
            }
        }
        return "你必须携带cookie信息来";
    }


    /*
     * @MethodName:getList
     * @Description:开发一个需要携带参数才能访问的get请求
     *              第一种实现方式：url:key1=value1&key2=value2....
     *              下面模拟获取商品列表
     * @14:12 2019/7/18
     * @Param:[start, end]
     * @Return:java.util.Map<java.lang.String,java.lang.Integer>
    */
    @RequestMapping(value="get/with/param",method = RequestMethod.GET)
    @ApiOperation(value="需要携带参数才能访问的get请求的第一种实现方式",httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start,
                                        @RequestParam Integer end) {
        Map<String ,Integer> myList = new HashMap<>();
        myList.put("鞋",100);
        myList.put("方便面",2);
        myList.put("篮球",150);
        myList.put("足球",110);
        myList.put("排球",120);
        myList.put("羽毛球",80);
        myList.put("乒乓球",35);
        return myList;
    }

    /*
     * @MethodName:
     * @Description:第二种需要携带参数访问的get请求
     *              区别于上面再访问路径上---URL：ip:port/get/with/param/10/20
     * @14:18 2019/7/18
     * @Param:
     * @Return:
    */

    @RequestMapping(value="/get/with/param/{start}/{end}")
    @ApiOperation(value="需要携带参数才能访问的get请求的第一种实现方式",httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start,
                            @PathVariable Integer end){
        Map<String ,Integer> myList = new HashMap<>();
        myList.put("鞋",100);
        myList.put("方便面",2);
        myList.put("篮球",150);
        myList.put("足球",110);
        myList.put("排球",120);
        myList.put("羽毛球",80);
        myList.put("乒乓球",35);
        return myList;

    }

}
