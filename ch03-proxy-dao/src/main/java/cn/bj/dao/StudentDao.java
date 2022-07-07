package cn.bj.dao;

import cn.bj.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
     List<Student> selectStudents ();
     Student selectStudent(@Param("myid") Integer id);
     int insertStudent(Student student);

}
