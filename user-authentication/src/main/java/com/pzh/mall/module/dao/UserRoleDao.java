package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/1 16:51
 * @Version 1.0
 */
@Mapper
public interface UserRoleDao {

    /**
     * 根据用户名获取所有角色
     *
     * @param userName
     * @return
     */
    List<Role> findByUserName(String userName);
}
