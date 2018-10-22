package com.wangyi.wangyi_yanxuan.manager;


import com.wangyi.wangyi_yanxuan.common.ResultUtil;
import com.wangyi.wangyi_yanxuan.domain.Grade;
import com.wangyi.wangyi_yanxuan.mapper.GradeMapper;
import com.wangyi.wangyi_yanxuan.service.GradeService;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GradeServiceImpl implements GradeService {


    /**
     *
     */
    @Autowired
    private GradeMapper gradeMapper;


    @Override
    public List<Grade> selectAll(int page, int limit) {

//        Map<String,Object> map1=new HashMap<String, Object>();
        int currPage=(page-1) * limit;
//        map1.put("currPage",currPage);
//        map1.put("size",limit);

       List<Grade> list = null;
        try {
            list= gradeMapper.selectAllPage(currPage,limit);

       } catch (Exception e) {
        e.printStackTrace();
        }

        return list;
    }

    @Override
    public int conutTologin() {
        int i= 0;
        try {
           i = gradeMapper.conutTologin();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public void deleteByPrimaryKey(Integer gid) {
        int a = gradeMapper.selectdj(gid);
        int count = gradeMapper.selectComAll(gid);
        int list = gradeMapper.selectByAll(gid);
        if (a == 1 || a == 2){
            if (list == 0){

                try {
                    gradeMapper.deleteByPrimaryKey(gid);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }else {
                throw  new RuntimeException("滚");
            }

        }
        if (count == 0) {
            gradeMapper.deleteByPrimaryKey(gid);
        }

    }

    @Override
    public void updateByPrimaryKey(Grade grade) {

        try {

            gradeMapper.updateByPrimaryKey(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Grade> selectNumber(int grade) {


        List<Grade> list = null;
        try {
            list = gradeMapper.selectNumber(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void insertGrade(Grade grade) {

        try {
           gradeMapper.insertGrade(grade);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    //模糊搜索
    @Override
    public List<Grade> countNumber(String gradename) {

        List<Grade> list = null;
        try {
           list =  gradeMapper.countNumber(gradename);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}