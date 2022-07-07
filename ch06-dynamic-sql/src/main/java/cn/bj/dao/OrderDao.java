package cn.bj.dao;


import cn.bj.domain.Student;

import java.util.List;

public interface OrderDao {

    //动态sql ，必须的使用java对象作为参数  if
    List<Student> selectStudentIf(Student student);

    //where
    List<Student> selectStudentWhere(Student student);

    //foreach 用法一
    List<Student> selectForeachOne(List<Integer> idList);
    //foreach 用法二  就是传过去的参数不一样
    List<Student> selectForeachTwo(List<Student> studentList);

}
