package com.enjoy.controller;

import com.enjoy.session.CasFilter;
import com.enjoy.session.MyRequestWrapper;
import com.enjoy.session.UserForm;
import com.enjoy.utils.CookieBasedSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Controller
public class IndexController {
    @Autowired
    private RedisTemplate redisTemplate;

    //所有未登陆请求，都强制跳转到这个url
    @GetMapping("/toLogin")
    public String toLogin(Model model,MyRequestWrapper request,HttpServletResponse response) throws ServletException, IOException {
        if (request.isLogin()){
            String ticket = UUID.randomUUID().toString();
            //如果已经登录就生成一个时效令牌ticket，写入ticket+psessionId(k,v)带时效的kv到redis，然后跳转到原始请求站点的页面，
            //ticket作为时效令牌，用于从redis中获取sessionid，这样就共享了sessionid，完成了登录共享。
            redisTemplate.opsForValue().set(ticket,request.getSession().getId(),20, TimeUnit.SECONDS);
            return "redirect:"+request.getParameter("url")+"?ticket="+ticket;
        }
        //如果没有登录就跳转到登录页面
        UserForm user = new UserForm();
        user.setUsername("Peter");
        user.setPassword("Peter");
        user.setBackurl(request.getParameter("url"));
        model.addAttribute("user", user);

        return "login";
    }

    @PostMapping("/login")
    public void login(@ModelAttribute UserForm user,MyRequestWrapper request,HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("user",user);

        String ticket = UUID.randomUUID().toString();
        //登录完成后就生成一个时效令牌ticket，写入ticket+psessionId(k,v)带时效的kv到redis，然后跳转到原始请求站点的页面，
        //ticket作为时效令牌，用于从redis中获取sessionid，这样就共享了sessionid，完成了登录共享。
        redisTemplate.opsForValue().set(ticket,request.getSession().getId(),20, TimeUnit.SECONDS);
        CookieBasedSession.onNewCookie(request,response);
        response.sendRedirect(user.getBackurl()+"?ticket="+ticket);

    }

    @GetMapping("/index")
    public ModelAndView index(MyRequestWrapper request) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("index");
        modelAndView.addObject("user", request.getSession().getAttribute(CasFilter.USER_INFO));

        return modelAndView;
    }
}
