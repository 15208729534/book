package com.he.controller;

import com.he.service.ExcelService;
import com.he.vo.ExcelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/import")
    public String importData(@RequestParam("file")MultipartFile file){
        try {
            List<ExcelVO> list = excelService.list(file.getInputStream());
            for (ExcelVO excelVO : list) {
                System.out.println("excelVO = " + excelVO);
            }
        } catch (IOException e) {
            return "fail";
        }
        return "success";
    }

}
