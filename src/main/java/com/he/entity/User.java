package com.he.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * user
 * @author
 */
@Data
public class User implements Serializable {
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     *密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;

    /**
     * 用户所拥有的角色，可能为多个
     */
    private List<Role> roleList;

    private static final long serialVersionUID = 1L;
}
