/*
 * @Author:liuhting
 * @ClassName:AddUserCase
 * @Description:添加用户的测试case
 */
package com.course.model;

import lombok.Data;

@Data
public class AddUserCase {
    private String userName;
    private String password;
    private String sex;
    private int age;
    private String permission;
    private int df;
    private String expected;
}
