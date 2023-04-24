package com.he.controller;

import com.he.entity.TimeInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {


    //@GetMapping("/getTime")

    /**
     * 接收从前端传送过来的数据，请求格式是RequestBody
     * 方法1：前端输入格式为：2023-04-18T15:07:00
     * 方法2：后端LocalDateTime字段上使用注解
     *  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
     * @param timeInfo
     * @return
     */
    public String getTime(@RequestBody TimeInfo timeInfo){
        log.info("从前端接收到的时间为：" + timeInfo.getStartTime());
        return timeInfo.getStartTime()+"";
    }
}
