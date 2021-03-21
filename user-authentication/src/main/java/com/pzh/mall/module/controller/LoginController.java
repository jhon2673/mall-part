package com.pzh.mall.module.controller;

import com.pzh.mall.common.ResultMsg;
import com.pzh.mall.module.domain.User;
import com.pzh.mall.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/6 13:56
 * @Version 1.0
 */
@Controller
@RequestMapping
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultMsg login(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return new ResultMsg();
        } catch (UnknownAccountException e) {
            return new ResultMsg(1001, e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return new ResultMsg(1002, e.getMessage());
        } catch (LockedAccountException e) {
            return new ResultMsg(1003, e.getMessage());
        } catch (AuthenticationException e) {
            return new ResultMsg(1004, "认证失败!");
        }
    }

    @RequestMapping("/index")
    public String index(Model model) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping("/403")
    public String forbid() {
        return "403";
    }
}
