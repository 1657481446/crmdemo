package com.springboot.common.servlet;

import com.springboot.utils.UtilValidator;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Title: ServletInterceptor
 * @Description: 自定义拦截器
 * @Author: jiangwg
 * @CreateDate: 2020/7/10 9:47
 * @Version: 1.0
 */
@Component
public class ServletInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(UtilValidator.isEmpty((String)session.getAttribute("userName"))){
            System.out.println("session为空,已自动跳转登陆页面!");
            if(UtilValidator.isEmpty(request.getServletPath().replace("/",""))){
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }
            //设置跳转地址
            response.setHeader("redirectUrl", request.getContextPath()+"/login.jsp");
            //设置跳转使能
            response.setHeader("enableRedirect","true");
            response.flushBuffer();
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       // System.out.println("在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
    }
}
