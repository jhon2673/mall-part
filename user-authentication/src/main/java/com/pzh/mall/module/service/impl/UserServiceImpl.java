package com.pzh.mall.module.service.impl;

import com.pzh.mall.module.dao.UserDao;
import com.pzh.mall.module.domain.User;
import com.pzh.mall.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/6 14:47
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByUserName(String userName) {
        User user = userDao.findByUserName(userName);
        return user;
    }

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public void add(String userName, String password, String icon, String email, String nickName) {
//        userDao.add(userName, password, icon, email, nickName);
    }

    @Override
    public void delete(long id) {
//        userDao.delete(id);
    }


}
