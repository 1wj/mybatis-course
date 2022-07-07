package cn.bj;

import cn.bj.dao.StudentDao;
import cn.bj.domain.MyStudent;
import cn.bj.domain.Student;
import cn.bj.utils.MybatisUtil;
import cn.bj.vo.QueueParam;
import cn.bj.vo.ViewStudent;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {


    @Test
    public void  testSelectViewStudent(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
       ViewStudent students = dao.selectViewStudent(1005);
        System.out.println(students);

    }

    @Test
    public void  testSelectResultType(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int num = dao.selectResultType();
        System.out.println("学生的数量"+num);
    }

    @Test
    public void  testSelectReturnMap(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<Object,Object>map=new HashMap<>();
               map  = dao.selectReturnMap(1005);
        System.out.println(map);
    }

    @Test
    public void  testSelectAllResultMap(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
      List<Student> students = dao.selectAllResultMap();
      students.forEach(stu-> System.out.println("学生=="+stu));
    }

    @Test
    public void  testSelectMyStudent(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectMyStudent();
        students.forEach(stu-> System.out.println("学生=="+stu));
    }
    @Test
    public void  testSelectMyStudent2(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectMyStudent2();
        students.forEach(stu-> System.out.println("学生=="+stu));
    }
    @Test
    public void  testSelectLinkOne(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name="%李%";
        List<Student> students = dao.selectLinkOne(name);
        students.forEach(stu-> System.out.println("学生=="+stu));
    }
    @Test
    public void  testSelectLinkTwo(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name="李";
        List<Student> students = dao.selectLinkTwo(name);
        students.forEach(stu-> System.out.println("学生=="+stu));
    }
}
