package com.yk.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Tang
 * @Tate 2022/10/6-15:08
 * @Version 1.0
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户登录的session，如果有session信息才不会被拦截
        Object loginUser = request.getSession().getAttribute("loginUser");

        if(loginUser == null){  //没有登录
            request.setAttribute("msg","没有权限访问,请先登录");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
