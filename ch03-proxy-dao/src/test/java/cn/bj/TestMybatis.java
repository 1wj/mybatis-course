package cn.bj;

import cn.bj.dao.StudentDao;
import cn.bj.domain.Student;
import cn.bj.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMybatis {


    /**
     * 一级缓存（本地的会话缓存）默认是开启的只在一次sqlSession中有效，也就是拿到连接到关闭连接这个区间段
     * 缓存失效的情况：
     *      1.查询不同的东西
     *      2.增删改操作，可能会改变原来的数据，所以必定会刷新缓存
     *      3.查询不同的Mapper.xml
     *      4.手动清理缓存
     *一级缓存就是一个map 用的时候就从里面取 不用的时候map就不要了
     */
   // @Test
    public void testSelectStudent(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudent(1001);
        System.out.println(student);

        //2.插入
        Student student2=new Student();
        student2.setAge(22);
        student2.setEmail("dunshan@qq.com");
        student2.setId(1009);
        student2.setName("盾");
       dao.insertStudent(student2);
        sqlSession.commit();
        //3.清理缓存
        // sqlSession.clearCache();
        System.out.println("=============================");
        //查询两次一样的数据
        Student student1 = dao.selectStudent(1001);
        System.out.println(student1);
        sqlSession.close();
    }

    /**
     * 二级缓存 只会在一级缓存结束后才会起作用也就是sqlSession close后
     *  二级缓存也叫全局缓存，一级缓存的作用域太低了，所以诞生了二级缓存
     *  基于namespace级别的缓存，一个名称空间，对应一个二级缓存
     *  工作机制
     *      一个会话查询一条数据，这个数据就会被放在一级缓存中
     *      如果当前会话关闭了，这个会话对应的一级缓存就没了，但我们想要的是会话关闭了，一级缓存中的数据
     *      就会被保存到二级缓存中；
     *      新的会话查询信息，就可以从二级缓存中获取内容；
     *      不同的Mapper查出的数据会放在自己对应的缓存（map）中
     */

    @Test
    public void testSelectStudent2(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudent(1);
        System.out.println(student);
        sqlSession.close();


        SqlSession sqlSession2=MybatisUtil.getSqlSession();
        StudentDao dao2 = sqlSession2.getMapper(StudentDao.class);
        Student student2 = dao2.selectStudent(1);
        System.out.println(student2);
        sqlSession2.close();
    }
    @Test
    public void testSelectStudents(){

        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
         *  getMapper能获取dao接口对应的实现类对象
         */

        SqlSession sqlSession= MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectStudents();
    students.forEach(stu-> System.out.println(stu));
    sqlSession.close();
    }


    @Test
    public void testInserStudent(){

        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);

        Student student=new Student();
        student.setAge(20);
        student.setEmail("dunshan@qq.com");
        student.setId(1006);
        student.setName("盾山");

        int num = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("已修改的行数："+num);
        sqlSession.close();
    }


}
