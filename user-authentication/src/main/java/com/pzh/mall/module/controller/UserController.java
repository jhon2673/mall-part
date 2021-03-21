package com.pzh.mall.module.controller;

import com.pzh.mall.module.domain.User;
import com.pzh.mall.module.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/6 14:47
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/findByUserName")
    @ResponseBody
    public User findByUserName(String userName) {
        LOGGER.info("进入findByUserName，参数userName：" + userName);
        User user = userService.findByUserName(userName);

        return user;
    }


    @RequiresPermissions("user:list")
    @RequestMapping("/list")
    public String list(Model model) {
        LOGGER.info("列出所有用户(分页)");
        List<User> users = userService.list();
        model.addAttribute("value", "list");
        return "user";
    }

    @RequiresPermissions("user:add")
    @RequestMapping("/add")
    public String add(Model model, @RequestParam(defaultValue = "") String userName, @RequestParam(defaultValue = "") String password, @RequestParam(defaultValue = "") String icon, @RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String nickName) {
        LOGGER.info("新增用户 userName:" + userName + " password:" + password + " icon:" + icon + " email:" + email + " nickName:" + nickName);
        userService.add(userName, password, icon, email, nickName);
        model.addAttribute("value", "add");
        return "user";
    }

    @RequiresPermissions("user:delete")
    @RequestMapping("/delete")
    public String delete(Model model, @RequestParam(defaultValue = "0")long id) {
        LOGGER.info("删除用户 id:" + id);
        userService.delete(id);
        model.addAttribute("value", "delete");
        return "user";
    }
}
