package com.hp.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Curtain-call
 */
public class FrontendLoginInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //获取session
//        HttpSession session = request.getSession();
//        //前台
//        if(session.getAttribute("LoginIndexName") != null){
//            //有登录信息===》放行
//            return true;
//        }else {
//            //拦截,跳转
//            response.sendRedirect("/index/");
//            return false;
//        }
//    }
}
