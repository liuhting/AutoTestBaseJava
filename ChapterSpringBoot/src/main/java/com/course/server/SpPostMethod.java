/*
 * @Author:liuhting
 * @ClassName:SpPostMethod
 * @Description:使用SpringBoot开发post接口
 */
package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是使用SpringBoot开发的post接口")
public class SpPostMethod {
    //定义一个变量用来装cookie信息
    private static Cookie cookie;

    //用户登陆成功获取到cookie信息，然后再访问其他接口获取到列表信息

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，登陆成功后获取cookies信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "username", required = true) String userName,
                        @RequestParam(value = "password", required = true) String passWord) {
        if (userName.equals("liuhuiting") && passWord.equals("123456")) {
            cookie = new Cookie("login", "ture");
            response.addCookie(cookie);
            return "恭喜您登录成功";
        }
        return "用户名或密码错误";
    }


    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户列表", httpMethod = "Post")
    public String getUserList(HttpServletRequest request,
                              @RequestBody User u) {
        User user = new User();
        //获取Cookies
        Cookie[] cookie = request.getCookies();
        //验证Cookies是否合法
        for (Cookie c : cookie) {
            if (c.getName() == "login"
                    && c.getValue().equals("true")
                    && u.getUserName().equals("liuhuiting")
                    && u.getPassWord().equals("123456")) {
                user.setName("liu");
                user.setAge("18");
                user.setSex("woman");
                return user.toString();
            }
        }
        return "参数不合法";
    }

}
