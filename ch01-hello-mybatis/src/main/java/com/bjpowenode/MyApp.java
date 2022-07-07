package com.bjpowenode;
import org.apache.ibatis.io.Resources;
import com.bjpowenode.domain.Student;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp {
    public static void main(String[] args) throws IOException {
      //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始（target/classes）
        String config="mybatis.xml";
        //2.读取这个config表示的文件
            InputStream in= Resources.getResourceAsStream(config);
        //3.创建了sqlSessionFactoryBulider对象
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //4.创建SqlsessionFactory对象
            SqlSessionFactory factory=builder.build(in);
        //[重要]5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
            SqlSession sqlSession=factory.openSession();
        //[重要]6.指定要执行的sql语句的标识  sql映射文件中namespace +"."+标签的id值
            //String sqlId="com.bjpowenode.dao.StudentDao"+"."+"selectStudents";
            String sqlId="com.bjpowenode.dao.StudentDao.selectStudents";
        //7.执行sql语句，通过sqlId找到语句
            List<Student> studentList= sqlSession.selectList(sqlId);

        //8.输出结果
            studentList.forEach(stu -> System.out.println(stu));
        //9.关闭sqlSession对象
        sqlSession.close();
    }
}
