package com.wangyi.wangyi_yanxuan.controller;


import com.wangyi.wangyi_yanxuan.domain.Commodity;
import com.wangyi.wangyi_yanxuan.service.GoodsService;
import com.wangyi.wangyi_yanxuan.utils.FileUtil;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GoodsController {
    @Autowired
    private GoodsService service;


    public String save(@RequestParam("picture")CommonsMultipartFile multipartFile, Commodity commodity, Model model, HttpServletRequest request){
        if (!multipartFile.isEmpty()){
            File dir =new File(new File(request.getServletContext().getRealPath("/")).getParent(),"17fmpics");
            if (!dir.exists()){
                dir.mkdir();
            }
            //需要存储的文件对象
            File tarFile = new File(dir, FileUtil.getFileName(multipartFile.getOriginalFilename()));
         //存储到服务器的指定路径
            try {
                multipartFile.transferTo(tarFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            commodity.setImgpath(tarFile.getName());
            System.out.println("文件上传路径"+tarFile.getAbsolutePath());
            if (service.save(commodity)){
                return "goodlist.do";
            }
        }
        model.addAttribute("msg","服务器繁忙，稍后再来");
        return  "addGoods.html";
    }
    //查询全部

    @GetMapping("/goodslist.do")
      public  R findGoods(){
        R r = new R();
        List<Commodity> list = null;
        try {
            list = service.selectCommodity();
            r.setCode(200);
            r.setData(list);
            return r;
        } catch (Exception e) {
            r.setCode(400);
            r.setMsg(e.getMessage());
            return r;
        }
    }
     //删除
    @ResponseBody
    @DeleteMapping("/delect.do")
    public R delectGoods(Commodity commodity) {
        R r = new R();

        try {
            service.delete(commodity.getCid());
            r.setCode(200);
            return r;
        } catch (Exception e) {
            r.setCode(400);
            r.setMsg(e.getMessage());
            return r;
        }

    }

     //增加
    @ResponseBody
    @PostMapping("/addgoods.do")
    public R addGoods(Commodity commodity) {
        R r = new R();
        try {
             service.save(commodity);
            r.setCode(200);
            return r;
        } catch (Exception e) {
            r.setCode(400);
            r.setMsg(e.getMessage());
            return r;
        }

    }

    //修改
    @ResponseBody
    @RequestMapping("/updategood.do")
    public R updateGoods(Commodity commodity) {
        R r = new R();
        try {
            service.updateCommodityById(commodity);
            r.setCode(200);
            return r;
        } catch (Exception e) {
            r.setCode(400);
            r.setMsg(e.getMessage());
            return r;
        }
    }

    @ResponseBody
    @RequestMapping("/findStaffByPage.do")
    public Map<String, Object> findStaffByPage(Integer page, Integer limit) {
        Map<String, Object> map = new HashMap<>();

        try {
            List<Commodity> list = service.findByPage(page,limit);
            int i = service.countToCommodity();
            map.put("code", 0);
            map.put("count", i);
            map.put("data", list);
            return map;
        } catch (Exception e) {
            map.put("code", 1);
            return map;
        }
    }

}
