package com.pzh.mall.module.domain;

import java.io.Serializable;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/6/11 20:01
 * @Version 1.0
 */
public class Resource implements Serializable {
    private static final long serialVersionUID = -4048475804212570672L;

    private Long id;
    private String name;
    private String url;
    private String description;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
