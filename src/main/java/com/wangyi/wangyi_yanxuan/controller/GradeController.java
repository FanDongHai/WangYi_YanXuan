package com.wangyi.wangyi_yanxuan.controller;

import com.wangyi.wangyi_yanxuan.common.ResultUtil;
import com.wangyi.wangyi_yanxuan.domain.Grade;
import com.wangyi.wangyi_yanxuan.service.GradeService;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GradeController {


    @Autowired
    private GradeService gradeService;


    //分页
    @PostMapping("/GradeFind.do")
   public Map<String, Object> selectAll(int page, int limit){
        Map<String,Object> map1 = new HashMap<String, Object>();

        List<Grade> list = null;
        int i = 0;
        try {
            list = gradeService.selectAll(page,limit);
            i = gradeService.conutTologin();
           map1.put("code",0);
           map1.put("count",i);
           map1.put("data",list);
           return map1;
        } catch (Exception e) {
            e.printStackTrace();
            map1.put("code",1);
            map1.put("msg",e.getMessage());
            return map1;
        }

    }


    //删除
    @PostMapping("/deleteGrade.do")
    public void deleteGrade(int gid){

        try {

             gradeService.deleteByPrimaryKey(gid);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //修改
    @PostMapping("/updateGrade.do")
    public void updateGradae(Grade grade){

        try {
            gradeService.updateByPrimaryKey(grade);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    //添加时搜索一级或者二级商品种类    添加需要有对应的上级商品种类
    @PostMapping("/selectNumber.do")
    public Map<String,Object> selectNumber(int grade){
    Map<String,Object> map = new HashMap<String, Object>();
        List<Grade> list = null;
        try {
            list = gradeService.selectNumber(grade);
            map.put("code",0);
            map.put("data",list);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",1);
            map.put("msg",e.getMessage());
            return map;
        }

    }


    //添加
    @PostMapping("/insertGrade.do")
    public Map<String,Object> insertGrade(Grade grade){


        Map<String,Object> map = new HashMap<String, Object>();
        try {
           gradeService.insertGrade(grade);
           map.put("code",0);
          return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",1);
        return map;
        }

    }


    //模糊搜索
    @PostMapping("/selectByAllPage.do")
    public Map<String,Object> selectByAllPage(String gradename){
        Map<String,Object> map1=new HashMap<>();
       List<Grade> list = null;
            try {
           list= gradeService.countNumber(gradename);
           map1.put("code",0);
           map1.put("data",list);
           return map1;

        } catch (Exception e) {
            e.printStackTrace();
            map1.put("code",1);
            map1.put("msg",e.getMessage());
            return map1;
            }


    }











}
