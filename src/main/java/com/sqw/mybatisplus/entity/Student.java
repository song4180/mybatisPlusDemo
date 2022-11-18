package com.sqw.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_student")
public class Student implements Serializable {
    @TableField(value = "sno")
    private int sno;
    @TableField(value = "sname")
    private String sname;
    @TableField(value = "age")
    private int age;
    @TableField(value = "sex")
    private String sex;
    @TableField(value = "sclass")
    private String sclass;
}
