package com.pzh.mall.module.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/11 19:59
 * @Version 1.0
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -6995889978793449142L;

    private Long id;
    private String name;
    private String description;
    private Integer status;
    private Integer sort;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
