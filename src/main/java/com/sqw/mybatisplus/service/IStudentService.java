package com.sqw.mybatisplus.service;

import com.sqw.mybatisplus.entity.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 根据唯一性主键进行查询  sno是唯一性主键
     *
     * @param sno
     * @return
     */
    Student getBySno(int sno);

    /**
     * 查询全部
     *
     * @return
     */
    List<Student> getAll();

    /**
     * 根据性别和年龄查询
     *
     * @param sex
     * @param age
     * @return
     */
    List<Student> getBySexAge(String sex, int age);

    /**
     * 范围&多条件查询
     *
     * @param age
     * @return
     */
    List<Student> getStudentsByScope(int age);

    /**
     * 添加学生
     *
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 根据指定条件删除
     *
     * @param sno
     * @return
     */
    int deleteBySno(int sno);

    /**
     * 根据多个指定条件删除
     *
     * @param sclass
     * @param sex
     * @return
     */
    int deleteBySclass_sex(String sclass, String sex);

    /**
     * 更新
     *
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 获取表中总记录数
     * @return
     */
    int getCount();
}
