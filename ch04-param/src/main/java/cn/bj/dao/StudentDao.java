package cn.bj.dao;

import cn.bj.domain.Student;
import cn.bj.vo.QueueParam;
import org.apache.ibatis.annotations.Param;

import java.net.Inet4Address;
import java.util.List;
import java.util.Map;

public interface StudentDao {

     //一个简单参数
     Student selectStudent1( Integer id);

      // 多个参数：命名参数，在形参定义的前面加入@Param("自定义参数名称")

     List<Student> selectMulitParam(@Param("myname")String name,
                                    @Param("myage") Integer age);

     //多个参数： 使用java对象作为借口中方法的参数
     List<Student> seletcMulitObject(QueueParam queueParam);

     //灵活一点 对象不一定自定义可以使用以拥有的
     List<Student> seletcMulitStudent(Student student);


     //多个参数  简单类型的 按位置传输
     List<Student> selectMulitPosition(String name, Integer id);

     //多个参数 使用map存放多个值
     List<Student> selectMulitByMap(Map<String,Object> map);



     //使用$而不用#会有sql注入的问题
     Student selectUse$(@Param("myname") String name);

     //一般用$替换列名或表名
     List<Student>  selectUse$Order(@Param("mycol") String col);

}
