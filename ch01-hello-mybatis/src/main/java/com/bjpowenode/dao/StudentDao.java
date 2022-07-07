package com.bjpowenode.dao;

import com.bjpowenode.domain.Student;

import java.util.List;

//接口操作student表
public interface StudentDao {
     List<Student> selectStudents();
     int insertStudents(Student student);

}
