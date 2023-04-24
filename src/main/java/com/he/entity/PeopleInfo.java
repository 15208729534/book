package com.he.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * peopleinfo
 * @author Hcl
 */
@Data
public class PeopleInfo implements Serializable {
    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 书籍ID
     */
    private Integer bookId;

    /**
     * 人物姓名
     */
    private String name;

    /**
     * 人物性别 1/0 男/女
     */
    private Boolean gender;

    /**
     * 人物描述
     */
    private String desc;

    /**
     * 0/1 未/已删除
     */
    private int isDelete;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    private static final long serialVersionUID = 1L;
}