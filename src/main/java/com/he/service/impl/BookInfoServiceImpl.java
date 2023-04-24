package com.he.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.he.entity.BookInfo;
import com.he.mapper.BookInfoMapper;
import com.he.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookInfoServiceImpl implements BookInfoService {

    @Autowired
    private BookInfoMapper bookInfoMapper;

    @Override
    public boolean insert(BookInfo bookInfo) {
        return bookInfoMapper.insert(bookInfo) > 0;
    }

    @Override
    public boolean deleteById(int id) {
        return bookInfoMapper.deleteById(id) > 0;
    }

    @Override
    public boolean updateById(BookInfo bookInfo) {
        return bookInfoMapper.updateById(bookInfo) > 0;
    }

    @Override
    public PageInfo<BookInfo> selectPageList(int currentPage, int size) {
        PageHelper.startPage(currentPage, size);
        List<BookInfo> bookInfoList = bookInfoMapper.selectList();
        PageInfo<BookInfo> bookInfoPageList = new PageInfo<>(bookInfoList);
        return bookInfoPageList;
    }
}
