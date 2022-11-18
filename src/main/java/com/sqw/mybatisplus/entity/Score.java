package com.sqw.mybatisplus.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_score")
public class Score {
    @TableField(value = "sno")
    private int sno;
    @TableField(value = "subject")
    private String subject;
    @TableField(value = "score")
    private int score;
}
