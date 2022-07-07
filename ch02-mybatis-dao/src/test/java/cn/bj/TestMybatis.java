package cn.bj;

import cn.bj.dao.StudentDao;
import cn.bj.dao.impl.StudentDaoImpl;
import cn.bj.domain.Student;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        //cn.bg.dao.StudentDao
        StudentDao dao=new StudentDaoImpl();
        /**
         * List<Student> students = dao.selectStudents(); 调用
         * 1.dao对象，类型是StudentDao,全限定名称是：cn.bj.dao.StudentDao
         * 全限定名称 和 namespace 是一样的 ”namespace“
         *也就是通过dao就拿到了namespace了
         *
         *
         * 2.dao 调用的方法名称，这个方法名称就是mapper文件中的id值
         * 也就是通过方法调用就拿到了id了
         *
         * 两个合起来就是sqId
         *
         *
         * 3.通过dao中方法的返回值也可以确定SqlSession的方法
         *      如果返回值是List,调用的是SqlSession.selectList().
         *      如果返回值是int,或是非List mapper文件中 标签是<insert><update>,就会调用
         *      SqlSession的insert,update方法
         *
         *
         * mybatis的动态代理：mybatis根据dao的方法调用,获取执行sql语句的信息
         *      mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建出该类的对象
         *      来完成sqlsession的调用方法，执行sql语句
         *
         *
         *
         *    核心：也就是自动创建实现类完成sqlsession方法的调用
         */
        List<Student> students = dao.selectStudents();
    students.forEach(stu-> System.out.println(stu));

    }
    @Test
    public void testInserStudent(){
        Student student=new Student();
        student.setAge(20);
        student.setEmail("dunshan@qq.com");
        student.setId(1006);
        student.setName("张三");

        StudentDao dao=new StudentDaoImpl();
        int num = dao.insertStudent(student);
        System.out.println("已修改的行数："+num);
    }
}
