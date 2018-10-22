package com.wangyi.wangyi_yanxuan.service;

import com.wangyi.wangyi_yanxuan.domain.Grade;
import com.wangyi.wangyi_yanxuan.vo.R;

import java.util.List;
import java.util.Map;

public interface GradeService {

    /**
     * 分页  dao层有辅助语句  查询总条数
     * @param page 当前页
     * @param limit 数据条数
     * @return
     */
    List<Grade> selectAll(int page, int limit);

    int conutTologin();

    /**
     * 按id删除 如果一级或二级下边有数据  删除不了
     * dao 层有判断语句
     * @param gid
     * @return
     */
   void deleteByPrimaryKey(Integer gid);

    /**
     * 按id 修改单条数据
     * @param grade
     * @return
     */
   void updateByPrimaryKey(Grade grade);

    /**
     * 查询一级或二级列表
     * 辅助添加语句
     * @param grade
     * @return
     */
    List<Grade> selectNumber(int grade);

    /**
     * 添加商品种类
     * @param grade
     */
    void insertGrade(Grade grade);


    //模糊查询
    List<Grade> countNumber(String gradename);

}
