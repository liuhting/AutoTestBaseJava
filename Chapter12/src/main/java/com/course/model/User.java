/*
 * @Author:liuhting
 * @ClassName:User
 * @Description:
 */
package com.course.model;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private String sex;
    private int age;
    //用户权限
    private String permission;
    //删除标志：0--未删除，1--已删除
    private int df;

    @Override
    public String toString() {
        return (
                "{id:" + id + "," +
                        "userName:" + userName + "," +
                        "password:" + password + "," +
                        "sex:" + sex + "," +
                        "age:" + age + "," +
                        "permission:" + permission + "," +
                        "df:" + df + "}"

        );

    }

}
