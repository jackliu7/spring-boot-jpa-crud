package com.edward.springbootcrud.controller;

import com.edward.springbootcrud.bean.User;
import com.edward.springbootcrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/user/login")
    public String login(User user, Map<String,Object> map, HttpSession session){
        User loginuser = userRepository.findByNameAndAndPassword(user.getName(), user.getPassword());
        if(loginuser !=null){
            session.setAttribute("loginuser",loginuser);
            return "redirect:/main.html";
        } else {
            map.put("msg","用户名或密码错误！");
            return "login";
        }
    }




}
