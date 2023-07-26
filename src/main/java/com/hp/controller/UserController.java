package com.hp.controller;

import com.hp.pojo.Users;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**前往客户列表页面*/
    @RequestMapping("/toUser_List")
    public String toUser_List(Model model, HttpServletRequest request){
        String currentPage = request.getParameter("currentPage");
        if(currentPage == null){
            currentPage = "1";
        }
        //System.out.println(currentPage);
        List<Users> findUser = userService.getFindUser(currentPage);
        int userPage = userService.getUserPage();
        //System.out.println("【debug】====>"+findUser);
        model.addAttribute("findUser",findUser);
        model.addAttribute("PageCount",userPage);
        model.addAttribute("currentPage",currentPage);
        return "admin/user_list";
    }

    /**前往添加页面*/
    @RequestMapping("/toUser_Add")
    public String toUser_Add(){
        return "admin/user_add";
    }

    /**提交添加*/
    @RequestMapping("/userSave")
    public String getUserSave(Users users){
        int addUser = userService.getAddUser(users);
        if(addUser != 0){
            return "redirect:/user/toUser_List";
        }else {
            return "redirect:/user/toUser_List";
        }
    }

    /**前往重置密码页面*/
    @RequestMapping("/toUser_Reset/{id}")
    public String toUser_Reset(@PathVariable("id") int id,Model model){
        Users findUserById = userService.getFindUserById(id);
        model.addAttribute("findUserById",findUserById);
        return "admin/user_reset";
    }

    /**保存密码*/
    @RequestMapping("/userReset")
    public String getUserReset(Users users){
        int updateUserPwd = userService.getUpdateUserPwd(users);
        if(updateUserPwd != 0){
            return "redirect:/user/toUser_List";
        }else {
            return "redirect:/user/toUser_List";
        }
    }

    /**前往修改页面*/
    @RequestMapping("/toUserEdit/{id}")
    public String toUserEdit(@PathVariable("id") int id,Model model){
        Users findUserById = userService.getFindUserById(id);
        model.addAttribute("findUserById",findUserById);
        return "admin/user_edit";
    }

    /**修改*/
    @RequestMapping("/userUpdate")
    public String getUserUpdate(Users users){
        int updateUser = userService.getUpdateUser(users);
        if(updateUser != 0){
            return "redirect:/user/toUser_List";
        }else {
            return "admin/user_list";
        }
    }

    /*删除用户*/
    @RequestMapping("/userDelete/{id}")
    public String getUserDelete(@PathVariable("id") int id){
        int deleteUser = userService.getDeleteUser(id);
        if(deleteUser != 0){
            return "redirect:/user/toUser_List";
        }else {
            return "admin/user_list";
        }
    }
}
