package com.sqw.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sqw.mybatisplus.entity.Student;
import com.sqw.mybatisplus.mapper.IStudentMapper;
import com.sqw.mybatisplus.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    @Qualifier("iStudentMapper")
    private IStudentMapper iStudentMapper;

    @Override
    public Student getBySno(int sno) {
        return iStudentMapper.selectById(sno);
    }

    @Override
    public List<Student> getAll() {
        return iStudentMapper.selectList(null);
    }

    @Override
    public List<Student> getBySexAge(String sex, int age) {
        Map<String, Object> map = new HashMap<>();
        map.put("sex", sex);
        map.put("age", age);
        return iStudentMapper.selectByMap(map);
    }

    @Override
    public List<Student> getStudentsByScope(int age) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        //ge表示大于等于、gt表示大于、le表示小于等于、lt表示小于
        //eq等于、ne不等于
        //between范围 between("age",20,30); 年龄范围20~30
        //查询年龄20-30范围 1.代表字段  2.代表开始值  3.代表结束值
       /* queryWrapper.gt("age",age);

        queryWrapper.gt("age",10); //年龄大于10
        queryWrapper.ge("age",10); //年龄大于等于10
        queryWrapper.le("age",10); //年龄小于等于10
        queryWrapper.lt("age",10); //年龄小于10
        queryWrapper.eq("age",10); //年龄等于10
        queryWrapper.ne("age",10); //年龄不等于10
        queryWrapper.between("age",20,30); //年龄介于20~30之间*/
        queryWrapper.gt("age", 10).eq("sex", "女"); //年龄大于10且性别为“女"
        return iStudentMapper.selectList(queryWrapper);

    }

    @Override
    public int insertStudent(Student student) {
        return iStudentMapper.insert(student);
    }


    @Override
    public int deleteBySno(int sno) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sno", sno);
        return iStudentMapper.delete(queryWrapper);
    }

    /**
     * 根据班级和性别删除
     *
     * @param sclass
     * @param sex
     * @return
     */
    @Override
    public int deleteBySclass_sex(String sclass, String sex) {
        Map<String, Object> map = new HashMap<>();
        map.put("sclass", sclass);
        map.put("sex", sex);
        return iStudentMapper.deleteByMap(map);
    }

    @Override
    public int updateStudent(Student student) {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sno", student.getSno());
        return iStudentMapper.update(student, queryWrapper);
    }

    @Override
    public int getCount() {
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sex","男");
        // return iStudentMapper.selectCount(null);  //null为获取表中总记录数
        return iStudentMapper.selectCount(queryWrapper);  //获取指定条件的记录数
    }
}
