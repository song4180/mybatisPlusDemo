package com.sqw.mybatisplus.mapper;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sqw.mybatisplus.entity.vo.StudentScoreVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: Song Qingwu
 * @date 2022/11/18 15:44
 * @Description:
 **/

@Component("iScoreMapper")
public interface IScoreMapper extends BaseMapper<StudentScoreVO> {
    /**
     * 获取学生成绩并分页显示
     * @return
     */
    @Select("select tst.sno,tst.sname,tsc.subject,tsc.score from t_student tst,t_score tsc where tst.sno=tsc.sno")
    List<StudentScoreVO> getScore();


    /**
     * 分页显示学生成绩
     * @param
     * @return
     */
    @Select("select tst.sno,tst.sname,tsc.subject,tsc.score from t_student tst,t_score tsc where tst.sno=tsc.sno")
    IPage<StudentScoreVO> getByPage(Page<StudentScoreVO> studentScoreVOPage, QueryWrapper<StudentScoreVO> queryWrapper);


    @Select("select count(*) from t_student tst,t_score tsc where tst.sno=tsc.sno")
    int getCount();
}
