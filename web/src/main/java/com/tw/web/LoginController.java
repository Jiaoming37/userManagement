package com.tw.web;

import com.tw.core.User;
import com.tw.core.service.PasswordService;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by jiaoming on 6/25/15.
 */

@RestController
@RequestMapping("/login")
public class LoginController {

    private UserService userService;
    private PasswordService passwordService;

    @Autowired
    public LoginController(UserService userService,PasswordService passwordService) {
        this.userService = userService;
        this.passwordService=passwordService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView("userLogin");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView confirmOfLogin(@ModelAttribute User user,
                                       @CookieValue(value="cookieNameLastUrl",required = false) String cookieNameLastUrl,
                                       HttpSession session,HttpServletResponse response) {
        ModelAndView modelAndView;
        String encryptPassword=passwordService.encrypt(user.getPassword());
        List<User> list=userService.findByNameAndPassword(user.getName(),encryptPassword);
        if(list.size()==0){
            modelAndView=new ModelAndView("userLogin");
        }else{
            session.setAttribute("name",user.getName());
            //System.out.print(cookieNameLastUrl+"fffffffffffffffffffffffffffffffffffff");
            String redirectUrl=(cookieNameLastUrl==null ?"/user/":cookieNameLastUrl);
            modelAndView=new ModelAndView("redirect:"+redirectUrl);
            //modelAndView=new ModelAndView("userList");
            //modelAndView.addObject("users", userService.listUser());
        }
        return  modelAndView;
    }
}
