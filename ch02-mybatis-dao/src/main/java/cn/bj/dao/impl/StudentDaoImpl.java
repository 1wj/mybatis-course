package cn.bj.dao.impl;

import cn.bj.dao.StudentDao;
import cn.bj.domain.Student;
import cn.bj.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        String sqlId="cn.bj.dao.StudentDao.selectStudents";
       List <Student> students=sqlSession.selectList(sqlId);
       sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession= MybatisUtil.getSqlSession();
        String sqlId="cn.bj.dao.StudentDao.insertStudent";
        int num = sqlSession.insert(sqlId, student);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
