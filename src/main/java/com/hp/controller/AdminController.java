package com.hp.controller;

import com.hp.pojo.Admins;
import com.hp.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Curtain-call
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminsService adminsService;

//    @GetMapping("/")
//    public String toIndex(){
//        return "index";
//    }

    /**前往登录页面*/
    @RequestMapping("/toLogin")
    public String toLogin(){
        //System.out.println("【debug】===》进入到了login请求");
        return "admin/login";
    }

    /**登陆验证*/
    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpServletRequest request){
        /**System.out.println("【debug】===》username的值为："+username);
        System.out.println("【debug】===》password的值为："+password);*/

        /**！！！密码加密*/
        Admins adminsLogin = adminsService.getAdminsLogin(username, password);
        if(adminsLogin != null){
            request.getSession().setAttribute("LoginName",adminsLogin.getUsername());
            return "admin/index";
        }else {
            model.addAttribute("msg","账号或密码错误，请重新输入！");
            return "admin/login";
        }
    }

    /**进入首页*/
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "admin/index";
    }

    /**获取管理员表数据总行数*/


    /**前往管理员列表页面*/
    @RequestMapping("/toAdmin_List")
    public String toAdmin_List(Model model,HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");
        if(currentPage == null){
            currentPage = "1";
        }
        int adminsPage = adminsService.getAdminsPage();
        model.addAttribute("PageCount",adminsPage);
        model.addAttribute("currentPage",currentPage);
        List<Admins> allAdmins = adminsService.getAllAdmins(currentPage);
        model.addAttribute("allAdmins",allAdmins);
        return "admin/admin_list";
    }

    /**前往修改密码页面*/
    @RequestMapping("toAdmin_Reset/{id}")
    public String toAdmin_Rest(@PathVariable(name = "id") int id, Model model){
        Admins adminsById = adminsService.getAdminsById(id);
        model.addAttribute("adminsById",adminsById);
        return "admin/admin_reset";
    }

    /**提交修改密码*/
    @RequestMapping("adminReset")
    public String getAdminReset(Admins admins){
        int updateAdmins = adminsService.getUpdateAdmins(admins);
        if(updateAdmins != 0 ){
            return "redirect:/admin/toAdmin_List";
        }else {
            return "admin/admin_list";
        }
    }

    /**前往增加页面*/
    @RequestMapping("/toAdmin_Add")
    public String toAdmin_Add(){
        return "admin/admin_add";
    }

    /**保存增加*/
    @RequestMapping("/adminSave")
    public String getAdminSave(Admins admins){
        int addAdmins = adminsService.getAddAdmins(admins);
        if(addAdmins != 0){
            return "redirect:/admin/toAdmin_List";
        }else {
            return "admin/admin_list";
        }
    }

    /**删除*/
    @RequestMapping("/adminDelete/{id}")
    public String getAdminDelete(@PathVariable(name = "id") int id){
        int deleteAdmins = adminsService.getDeleteAdmins(id);
        if(deleteAdmins != 0){
            return "redirect:/admin/toAdmin_List";
        }else {
            return "admin/admin_list";
        }
    }


    /**退出登录*/
    @RequestMapping("/logout")
    public String getLogOut(HttpServletRequest request){
        request.getSession().removeAttribute("LoginName");
        return "admin/login";
    }

}
