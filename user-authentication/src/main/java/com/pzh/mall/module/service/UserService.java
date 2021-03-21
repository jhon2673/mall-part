package com.pzh.mall.module.service;


import com.pzh.mall.module.domain.User;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/6 14:46
 * @Version 1.0
 */
public interface UserService {

    User findByUserName(String userName);

    /**
     * 列出所有用户
     * @return
     */
    List<User> list();

    /**
     * 新增用户
     * @param userName
     * @param password
     * @param icon
     * @param email
     * @param nickName
     */
    void add(String userName, String password, String icon, String email, String nickName);

    /**
     * 删除用户
     * @param id
     */
    void delete(long id);
}
