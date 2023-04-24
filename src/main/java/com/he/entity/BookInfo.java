package com.he.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * bookinfo
 *
 * @author Hcl
 */
@Data
public class BookInfo implements Serializable {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 书籍介绍
     */
    private String intro;

    /**
     * 书籍名称
     */
    private String name;

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
