package com.hp.controller;

import com.hp.dao.TypeMapper;
import com.hp.pojo.Goods;
import com.hp.pojo.Types;
import com.hp.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/good")
public class GoodController {

    @Autowired
    private GoodService goodService;

    @Autowired
    private TypeMapper typeMapper;

    /**前往商品列表页面*/
    @RequestMapping("/toGood_List")
    public String toGood_List(Model model){
        List<Goods> findGood = goodService.getFindGood();
        //System.out.println(findGood);
        model.addAttribute("findGood",findGood);
        return "admin/good_list";
    }

    /**前往增加商品页面*/
    @RequestMapping("/toGoodAdd")
    public String toGoodAdd(Model model){
        List<Types> findType = typeMapper.getFindType();
        model.addAttribute("findType",findType);
        return "admin/good_add";
    }


    /**前往修改商品页面*/
    @RequestMapping("/toGoodEdit/{id}")
    public String toGoodUpdate(@PathVariable("id") int id,Model model){
        Goods findGoodById = goodService.getFindGoodById(id);
        //System.out.println(findGoodById);
        model.addAttribute("findGoodById",findGoodById);
        List<Types> findType = typeMapper.getFindType();
        model.addAttribute("findType",findType);
        return "admin/good_edit";
    }

    /**确认修改*/
    @RequestMapping("/goodUpdate")
    public String getGoodUpdate(Goods goods){
        //System.out.println("【debug】====》获取到的goods为"+goods.toString());
        int updateGood = goodService.getUpdateGood(goods);
        if(updateGood != 0){
            return "redirect:/good/toGood_List";
        }else {
            return "redirect:/good/toGood_List";
        }
    }

    /**保存增加的商品信息*/
    @RequestMapping("/goodSave")
    public String getGoodSave(@PathVariable("multipartFile") MultipartFile multipartFile,Goods goods) {
        //图片名
        String imageName = multipartFile.getOriginalFilename();
        goods.setCover("../upload/"+imageName);

        int addGood = goodService.getAddGood(goods);
        if(addGood != 0){
            return "redirect:/good/toGood_List";
        }else {
            return "redirect:/good/toGood_List";
        }
    }

    /**删除商品*/
    @RequestMapping("/goodDelete/{id}")
    public String getGoodDelete(@PathVariable("id") int id){
        int deleteGood = goodService.getDeleteGood(id);
        if(deleteGood != 0){
            return "redirect:/good/toGood_List";
        }else {
            return "redirect:/good/toGood_List";
        }
    }
}
