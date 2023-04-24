package com.he.mapper;

import com.he.entity.BookInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookInfoMapper {

    int insert(BookInfo bookInfo);

    int deleteById(int id);

    int updateById(BookInfo bookInfo);

    List<BookInfo> selectList();
}