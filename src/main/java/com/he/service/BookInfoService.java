package com.he.service;

import com.github.pagehelper.PageInfo;
import com.he.entity.BookInfo;

public interface BookInfoService {

    /**
     * 新增书籍信息
     * @param bookInfo
     * @return
     */
    boolean insert(BookInfo bookInfo);

    boolean deleteById(int id);

    boolean updateById(BookInfo bookInfo);

    PageInfo<BookInfo> selectPageList(int currentPage,int size);
}
