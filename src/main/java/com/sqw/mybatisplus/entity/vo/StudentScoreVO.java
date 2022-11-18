package com.sqw.mybatisplus.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author: Song Qingwu
 * @date 2022/11/18 15:44
 * @Description:两表的连表查询
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScoreVO implements Serializable {
    @TableField(value = "sno")
    private int sno;
    @TableField(value = "sname")
    private String sname;
    @TableField(value = "subject")
    private String subject;
    @TableField(value = "score")
    private int score;
}
