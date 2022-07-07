package cn.bj;

import cn.bj.dao.StudentDao;
import cn.bj.domain.Student;
import cn.bj.utils.MybatisUtil;
import cn.bj.vo.QueueParam;
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
    public void testSelectStudent1(){
        /**
         * 1.parameterType :显示mapper文件中的一个属性，表示dao接口中方法的参数的数据类型
         * 例如：Student selectStudent1(Integer id); 这个Integer
         *
         *
         * 2.一个简单类型的参数：
         * 简单类型：Mybatis把Java的基本数据类型和String都叫简单类型
         *
         * 必须在mapper 文件中获取简单类型的一个参数的值，使用#{任意字段}
         *
         *
         */
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

     Student student = dao.selectStudent1(1005);
        System.out.println(student);
        sqlSession.close();
    }
    @Test
    public void  testSelectMulitParam(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMulitParam("李四", 20);
        students.forEach(stu-> System.out.println(stu));
        sqlSession.close();
    }
    @Test
    public void testSelectMulityObject(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueueParam queueParam=new QueueParam();
        queueParam.setParamName("李四");
        queueParam.setParamAge(20);

        List<Student> students = dao.seletcMulitObject(queueParam);
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
    @Test
    public void testSelectMulityStudent(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student=new Student();
        student.setName("李四");
        student.setAge(20);

        List<Student> students = dao.seletcMulitStudent(student);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }
    @Test
    public void testSelectMulityPosition(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMulitPosition("李四",20);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testSelectMulitByMap(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String,Object> data=new HashMap<>();
        data.put("mynaem","张三");
        data.put("myage",20);
        List<Student> students = dao.selectMulitByMap(data);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }
    @Test
    public void testSelectUse$(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

       Student students = dao.selectUse$("'李四'");
        System.out.println(students);
        sqlSession.close();
    }

    @Test
    public void testSelectUse$Order(){
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectUse$Order("name");
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }
}
