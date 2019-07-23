/*
 * @Author:liuhting
 * @ClassName:DatabaseUtil
 * @Description:数据库的工具类文件
 */
package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {

    public static SqlSession getSqlSession() throws IOException {
        //获取配置的资源文件
        Reader reader= Resources.getResourceAsReader("databaseConfig.xml");
        //得到SQLSessionFactory，使用类加载器加载xml文件
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(reader);
        //得到sqlSession对象，这个对象就能执行配置文件中的sql语句
        SqlSession session= factory.openSession();

        return session;
    }
}
