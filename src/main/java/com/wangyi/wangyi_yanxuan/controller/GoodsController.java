package com.wangyi.wangyi_yanxuan.controller;


import com.wangyi.wangyi_yanxuan.domain.Commodity;
import com.wangyi.wangyi_yanxuan.service.GoodsService;
import com.wangyi.wangyi_yanxuan.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
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
    @RequestMapping("goodslist.do")

    public String list(Model model){
model.addAttribute("goodsList",service.queryByPage());
return "showGoods.html";
    }


}
