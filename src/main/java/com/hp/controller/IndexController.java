package com.hp.controller;

import com.hp.pojo.Goods;
import com.hp.pojo.Tops;
import com.hp.pojo.Users;
import com.hp.service.GoodService;
import com.hp.service.TopsService;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Curtain-call
 * 用户登录 控制器
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private TopsService topsService;
    @Autowired
    private GoodService goodService;

    /**前往首页页面*/
    @RequestMapping("/toIndex")
    public String toIndex(Model model){
        /**热销排行*/
        //1-3
        List<Tops> topsFirstList = topsService.getTopsFirstList();
        //4-8
        List<Tops> topsFourList = topsService.getTopsFourList();
        model.addAttribute("topsFirstList",topsFirstList);
        model.addAttribute("topsFourList",topsFourList);

        /**根据类型查询*/
        List<Goods> goodsByFruit = goodService.getGoodsByTypeName(1);
        List<Goods> goodsByMeat = goodService.getGoodsByTypeName(2);
        List<Goods> goodsByRice = goodService.getGoodsByTypeName(3);
        List<Goods> goodsBySnacks = goodService.getGoodsByTypeName(4);
        List<Goods> goodsByToy = goodService.getGoodsByTypeName(5);
        List<Goods> goodsByTool = goodService.getGoodsByTypeName(6);

        model.addAttribute("goodsByFruit",goodsByFruit);
        model.addAttribute("goodsByMeat",goodsByMeat);
        model.addAttribute("goodsByRice",goodsByRice);
        model.addAttribute("goodsBySnacks",goodsBySnacks);
        model.addAttribute("goodsByToy",goodsByToy);
        model.addAttribute("goodsByTool",goodsByTool);

        System.out.println(goodsByRice);

        return "index/index";
    }

    /**前往登录页面*/
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "index/login";
    }

    /**登录验证*/
    @RequestMapping("/login")
    public String getLogin(String username, String password, HttpServletRequest request, Model model, RedirectAttributes redirectAttributes){
        Users userLogin = userService.getUserLogin(username, password);
        //System.out.println(userLogin.toString());
        if(userLogin != null){
            request.getSession().setAttribute("UserLogin",userLogin.getUsername());
            //将用户传输给前端
            model.addAttribute("UserName",userLogin);
            return "redirect:/index/toIndex";
        }else {
            redirectAttributes.addFlashAttribute("msg","您输入的账号或密码不正确，请重新输入！");
            return "redirect:/index/toLogin";
        }
    }

    /**前往注册页面*/
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "index/register";
    }

    /**注册*/
    @RequestMapping("/register")
    public String getRegister(Users users, RedirectAttributes redirectAttributes, Model model,HttpServletRequest request){
        int addUser = userService.getAddUser(users);
        if(addUser != 0){
            request.getSession().setAttribute("UserLogin",users.getUsername());
            //将用户传输给前端
            model.addAttribute("UserName",users);
            return "index/index";
        }else {
            //重定向时携带消息
            redirectAttributes.addFlashAttribute("msg","注册失败！");
            return "redirect:/index/toRegister";
        }
    }

    /**热销排行*/
//    public String getTopList(){
//
//    }
}
