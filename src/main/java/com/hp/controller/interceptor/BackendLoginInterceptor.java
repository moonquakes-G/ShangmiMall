package com.hp.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Curtain-call
 * 后台登录拦截器
 */
public class BackendLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取session
        HttpSession session = request.getSession();
        //后台
        if(session.getAttribute("LoginName") != null){
            //有登录信息===》放行
            return true;
        }else {
            //拦截,跳转
            response.sendRedirect("/admin/");
            return false;
        }
    }

}
