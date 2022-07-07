package cn.bj;


import cn.bj.dao.OrderDao;
import cn.bj.dao.StudentDao;
import cn.bj.domain.Student;
import cn.bj.utils.MybatisUtil;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMybatis {

@Test
    public void testSelectStudentIf(){
        SqlSession session = MybatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student=new Student();
        student.setAge(18);
        student.setName("李四");
        List<Student> students = dao.selectStudentIf(student);
        students.forEach(stu-> System.out.println(stu));
    }
   //测试OrderDao.xml与OrderDao接口

    @Test
    public void testSelectStudentIf2(){
        SqlSession session = MybatisUtil.getSqlSession();
        OrderDao dao = session.getMapper(OrderDao.class);
        Student student=new Student();
        student.setAge(18);
        student.setName("李四");
        List<Student> students = dao.selectStudentIf(student);
        students.forEach(stu-> System.out.println(stu));

    }
@Test
    public void testSelectStudentWhere(){
        SqlSession session = MybatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student=new Student();
        student.setAge(18);
        student.setName("李四");
        List<Student> students = dao.selectStudentWhere(student);
        students.forEach(stu-> System.out.println("where==="+stu));

    }

    /**
     * 单纯的字符串拼接 StringBuilder  deleteCharAt()
     */
    @Test
    public void test(){
        List<Integer> list=new ArrayList();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        String sql="select * from student where id in";
        StringBuilder sb=new StringBuilder();
        sb.append("(");

        for(Integer i:list){
            sb.append(i);
            sb.append(",");
            //这两步二合一
           // sb.append(i).append(",");
        }
       sb.deleteCharAt(sb.length()-1);
        sb.append(")");
        System.out.println(sql+sb);
    }
    @Test
    public void testSelectForeachOne(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);
        List<Integer> idlist=new ArrayList<>();
        idlist.add(1001);
        idlist.add(1002);
        idlist.add(1003);
        List<Student> students = dao.selectForeachOne(idlist);
        for(Student stu:students){
            System.out.println("one##########"+stu);
        }
    }
    @Test
    public void testSelectForeachTwo(){
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        StudentDao dao= sqlSession.getMapper(StudentDao.class);
        List<Student> stuList=new ArrayList<>();
        Student s1=new Student();
        s1.setId(1001);
        stuList.add(s1);

        s1=new Student();
        s1.setId(1002);
        stuList.add(s1);
        List<Student> students = dao.selectForeachTwo(stuList);
        for(Student stu:students){
            System.out.println("two##########"+stu);
        }
    }

    @Test
    public void testSelectAll(){
    SqlSession sqlSession=MybatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //加入PageHelper的方法，分页 一般用limit 0,3
        //pageNum: 第几页，从1开始
        //pageSize:一页几行数据
        PageHelper.startPage(1,3);
        List<Student> students = dao.selectAll();
        students.forEach(stu-> System.out.println("pagehelper===="+stu));

    }
}
