package com.he.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * orders
 * @author 
 */
@Data
public class Orders implements Serializable {
    private Integer id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 备注
     */
    private String remark;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 因为期望Order中还能包含下单用户的数据，所以可以在Order中增加一个属性:
     */
    private User user;

    private static final long serialVersionUID = 1L;
}