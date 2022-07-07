package com.bjpowenode.utils;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis工具类 为了简化获得sqlSession 类似于包装
 */
public class MybatisUtil {
    private static SqlSessionFactory factory=null;
    static {
        try {
            String config="mybatis.xml";
            InputStream in = Resources.getResourceAsStream(config);
            factory=new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
//获取sqlSession的方法
    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        if (factory!=null){
             sqlSession=factory.openSession();
        }
        return sqlSession;
    }
}
