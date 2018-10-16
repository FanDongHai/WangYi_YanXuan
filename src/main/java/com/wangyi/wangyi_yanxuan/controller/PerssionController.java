package com.wangyi.wangyi_yanxuan.controller;

import com.wangyi.wangyi_yanxuan.domain.Perssion;
import com.wangyi.wangyi_yanxuan.service.PerssionService;
import com.wangyi.wangyi_yanxuan.utils.ResultUtil;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerssionController {
    @Autowired
    private PerssionService perssionService;
    // 根据id删除一个权限资源
    @GetMapping("/deletePerssionById.do")
    public R deletePerssionById(int id){
        try {
            perssionService.deletePerssionById(id);
           return ResultUtil.setOK("删除成功");
        } catch (Exception e) {
           return ResultUtil.setERROR("删除失败");
        }
    }
    // 添加一个权限资源
    @PostMapping("/addPerssion.do")
    public R addPerssion(Perssion perssion){
        try {
            perssionService.addPerssion(perssion);
            return ResultUtil.setOK("添加成功");
        } catch (Exception e) {
            return ResultUtil.setERROR("添加失败");
        }
    }
    // 展示所有的权限资源
    @PostMapping("/findAllPerssion.do")
    public R findAllPerssion(){
        List<Perssion> list = null;
        R r = new R();
        try {
            list = perssionService.findAllPerssion();
            r.setCode(200);
            r.setData(list);
            return r;
        } catch (Exception e) {
            r.setCode(400);
            r.setMsg(e.getMessage());
            return r;
        }
    }


}
