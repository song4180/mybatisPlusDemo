package com.sqw.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sqw.mybatisplus.entity.Student;
import org.springframework.stereotype.Component;

@Component("iStudentMapper")
public interface IStudentMapper extends BaseMapper<Student> {
}
