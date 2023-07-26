package com.hp.controller;

import com.hp.pojo.Types;
import com.hp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    /**前往类目列表页,加载数据*/
    @RequestMapping("/toType_List")
    public String toType_List(Model model){
        List<Types> findType = typeService.getFindType();
        model.addAttribute("findType",findType);
        return "admin/type_list";
    }

    /**前往修改页面*/
    @RequestMapping("/typeEdit/{id}")
    public String toType_Edit(@PathVariable(name = "id") int id, Model model){
        //System.out.println("【debug】===》获取到的ID为："+id);
        Types findTypeById = typeService.getFindTypeById(id);
        model.addAttribute("type",findTypeById);
        return "admin/type_edit";
    }

    /**提交修改*/
    @RequestMapping("/typeUpdate")
    public String getUpdateType(Types types,Model model){
        //System.out.println(types.toString());
        int updateType = typeService.getUpdateType(types);
        if(updateType != 0){
            return "redirect:/type/toType_List";
        }else {
            model.addAttribute("msg","修改失败");
            return "admin/type_edit";
        }
    }

    /**前往添加页面*/
    @RequestMapping("/type_add")
    public String toType_Add(){
        return "admin/type_add";
    }

    /**添加保存*/
    @RequestMapping("/typeSave")
    public String getAddType(Types types){
        //System.out.println(types.toString());
        int addType = typeService.getAddType(types);
        return "redirect:/type/toType_List";
    }

    /**删除*/
    @RequestMapping("/typeDelete/{id}")
    public String getDeleteType(@PathVariable(name = "id") int id, Model model){
        //System.out.println("【debug】===》获取到的ID为："+id);
        typeService.getDeleteType(id);
        return "redirect:/type/toType_List";
    }

}
