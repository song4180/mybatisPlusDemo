package com.sqw.mybatisplus.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sqw.mybatisplus.entity.vo.StudentScoreVO;
import com.sqw.mybatisplus.mapper.IScoreMapper;
import com.sqw.mybatisplus.service.IScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreServiceImpl implements IScoreService {

    @Autowired
    @Qualifier("iScoreMapper")
    private IScoreMapper iScoreMapper;

    @Override
    public List<StudentScoreVO> getScore() {
        return iScoreMapper.getScore();
    }

    @Override
    public IPage<StudentScoreVO> getByPage(Page<StudentScoreVO> studentScoreVOPage, QueryWrapper<StudentScoreVO> queryWrapper) {
        return iScoreMapper.getByPage(studentScoreVOPage,queryWrapper);
    }

    @Override
    public int getCount() {
        return iScoreMapper.getCount();
    }
}
