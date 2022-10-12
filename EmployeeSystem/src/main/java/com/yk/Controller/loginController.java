package com.yk.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author Tang
 * @Tate 2022/10/6-10:56
 * @Version 1.0
 */
@Controller
public class loginController {
    //用户登录
    @RequestMapping("/user/login")
//    @ResponseBody
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model, HttpSession session){
        session.setAttribute("loginUser",null);
        if(!StringUtils.isEmpty(username) && password.equals("123456")){
            session.setAttribute("loginUser", username);
            return "redirect:/main.html";
        }else{
            model.addAttribute("msg","用户名或者密码错误");
            return "index";
        }
    }
    //注销
    @RequestMapping("/user/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/index.html";
    }
}
