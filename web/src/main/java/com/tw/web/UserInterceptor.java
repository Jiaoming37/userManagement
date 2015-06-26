package com.tw.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jiaoming on 6/25/15.
 */
public class UserInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,
                             Object handler) throws Exception{

        HttpSession session=request.getSession();
        String cookieNameLastUrl=request.getRequestURI();
        if(session.getAttribute("name")==null){
            cookieNameLastUrl = cookieNameLastUrl.replaceFirst("/web", "");
            //System.out.print(cookieNameLastUrl+"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            CookieAPI.setCookie(response, "cookieNameLastUrl", cookieNameLastUrl);
            response.sendRedirect("/web/login/");
            return false;
        }
        return  true;
    }

    @Override
    public void postHandle(HttpServletRequest request,HttpServletResponse response,
                           Object handler,ModelAndView modelAndView) throws Exception{

        System.out.print("the HandlerAdapter has invoked the handler but DispatcherServlet is yet to render the view." +
                "the method can be used to add additional attribute to the ModelAndView object to be used in the view pages.");

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

        System.out.print("this is a callback method that is called once the handler is executed and view is rendered.");
    }
}
