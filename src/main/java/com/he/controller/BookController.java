package com.he.controller;

import com.github.pagehelper.PageInfo;
import com.he.entity.BookInfo;
import com.he.service.BookInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookInfoService bookInfoService;

    @PostMapping("/insert")
    private boolean BookInfo1(@RequestBody BookInfo bookInfo){
        return bookInfoService.insert(bookInfo);
    }

    @DeleteMapping("/delete/{id}")
    private boolean BookInfo2(@PathVariable("id") int id){
        return bookInfoService.deleteById(id);
    }

    @PutMapping("/update")
    private boolean BookInfo3(@RequestBody BookInfo bookInfo){
        return bookInfoService.updateById(bookInfo);
    }

    @GetMapping("/select")
    private PageInfo<BookInfo> BookInfo4(@Param("current") int current, @Param("size") int size){
        return bookInfoService.selectPageList(current,size);
    }

    @GetMapping("/test")
    private String test(){
        return "测试成功";
    }
}
