package com.wmxkb.util_useless;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

// 封装数据库的连接
public class MyBatisUtil {

    private static SqlSessionFactory sessionFactory;
    static {
        try {
            // 加载配置文件
            InputStream is = Resources.getResourceAsStream("mybatis.xml");

            // 创建sessionFactory对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sessionFactory = builder.build(is);
//            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 获取session对象
    // 获取工具类的session对象（数据库连接）
    // SqlSession session = MyBatisUtil.openSession();
    public static SqlSession openSession() {
        return sessionFactory.openSession();
    }
}


