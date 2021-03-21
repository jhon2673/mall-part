package com.pzh.mall.module.dao;

import com.pzh.mall.module.domain.Resource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/1 16:51
 * @Version 1.0
 */
@Mapper
public interface UserResourceDao {

    /**
     * 根据用户名获取所有权限
     *
     * @param userName
     * @return
     */
    List<Resource> findByUserName(String userName);
}
