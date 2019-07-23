/*
 * @Author:liuhting
 * @ClassName:GetUserListCase
 * @Description:
 */
package com.course.model;

import lombok.Data;

@Data
public class GetUserListCase {

    private String userName;
    private String sex;
    private int age;
    //预期结果
    private String expected;
}
