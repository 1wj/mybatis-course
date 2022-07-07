package cn.bj.dao;

import cn.bj.domain.MyStudent;
import cn.bj.domain.Student;
import cn.bj.vo.QueueParam;
import cn.bj.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

public interface StudentDao {

     //resultType的使用  返回的是一个对象 可以自定义
     ViewStudent selectViewStudent(@Param("sid") Integer id);

     //resultType的使用   返回的是一个简单类型 也就是返回一行一列
     int selectResultType();

     //resultType的使用   返回的是map
     Map<Object,Object> selectReturnMap(@Param("sid")Integer id);

     //使用resultMap定义映射关系
     List<Student> selectAllResultMap();

     //列名和属性名不一样 第一种 用resultMap
     List<MyStudent> selectMyStudent();

     //列名和属性名不一样 第二种 用resultType 得用列别名
     List<MyStudent> selectMyStudent2();

     //第一种模糊查询，在java代码指定like的内容
     List<Student> selectLinkOne(String name);

     //name就是“ 李 ” ，在mapper中拼接 like “%” 李 “%”
     List<Student> selectLinkTwo(String name);

}
