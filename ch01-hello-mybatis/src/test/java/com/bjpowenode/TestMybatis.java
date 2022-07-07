package com.bjpowenode;

import com.bjpowenode.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    //@Test
    public void testInsert() throws IOException {
        String config="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in= Resources.getResourceAsStream(config);
        //3.创建了sqlSessionFactoryBulider对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //4.创建SqlsessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //[重要]5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
       // SqlSession sqlSession=factory.openSession();
        //这个是获取一个可以自动提交事务的sqlSession对象
        SqlSession sqlSession=factory.openSession(true);
        //[重要]6.指定要执行的sql语句的标识  sql映射文件中namespace +"."+标签的id值
        //String sqlId="com.bjpowenode.dao.StudentDao"+"."+"selectStudents";
        String sqlId="com.bjpowenode.dao.StudentDao.insertStudents";
        //7.执行sql语句，通过sqlId找到语句
        Student student=new Student();
        student.setAge(24);
        student.setId(1005);
        student.setEmail("guanyu@qq.com");
        student.setName("关羽");
        int nums= sqlSession.insert(sqlId,student);
        //mybatis 默认不是自动提交事务的，所以在inset,updat,delete后要手工提交事务
     //   sqlSession.commit();
        //8.输出结果
        System.out.println("执行inser的结果："+nums);
        //9.关闭sqlSession对象
        sqlSession.close();


    }
}
