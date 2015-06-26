package com.tw.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiaoming on 6/25/15.
 */
public class CookieAPI {

    public static void setCookie(HttpServletResponse response,String cookieName,String cookieValue){
        eraseCookie(response,cookieName);
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public static void eraseCookie(HttpServletResponse response,String cookieName){
        Cookie cookie=createCookie(cookieName);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public static Cookie createCookie(String cookieName){
        Cookie cookie=new Cookie(cookieName,"value");
        cookie.setPath("/");
        return  cookie;
    }

}
