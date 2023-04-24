package com.he.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.he.service.ExcelService;
import com.he.vo.ExcelVO;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelServiceImpl implements ExcelService {

    @Override
    public List<ExcelVO> list(InputStream inputStream) {

        ArrayList<ExcelVO> list = new ArrayList<>();
        EasyExcel.read(inputStream)
                .head(ExcelVO.class)
                .sheet()
                .registerReadListener(new AnalysisEventListener<ExcelVO>() {

                    @Override
                    public void invoke(ExcelVO excelVO, AnalysisContext analysisContext) {
                        list.add(excelVO);
                    }

                    @Override
                    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                        System.out.println("解析完成");
                    }
                }).doRead();
        return list;
    }
}
