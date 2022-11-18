package com.sqw.mybatisplus.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sqw.mybatisplus.entity.vo.StudentScoreVO;

import java.util.List;

public interface IScoreService {
    /**
     *
     * @return
     */
    List<StudentScoreVO> getScore();

    /**
     *分页显示
     * @param
     * @return
     */
    IPage<StudentScoreVO> getByPage(Page<StudentScoreVO> studentScoreVOPage, QueryWrapper<StudentScoreVO> queryWrapper);

    /**
     *
     * @return
     */
    int getCount();
}
