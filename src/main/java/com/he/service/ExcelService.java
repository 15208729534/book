package com.he.service;

import com.he.vo.ExcelVO;

import java.io.InputStream;
import java.util.List;

public interface ExcelService {

    List<ExcelVO> list(InputStream inputStream);
}
