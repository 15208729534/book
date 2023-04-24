package com.he.controller;

import com.he.entity.User;
import com.he.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("user")
public class UserController {


    @Autowired
    @Qualifier("userServiceImpl")
    //@Qualifier(实现类类名首字母小写)
    private UserService userService;

    @GetMapping("selectMaps")
    public List<Map<String, User>> selectMaps(){
        return userService.selectMaps();
    }

    @GetMapping("findUserById/{id}")
    public User findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    // 注意：axios发送json格式数据时，不能用Get方法
    //@CrossOrigin(origins = "http://localhost:8080", maxAge = 3600)
    @PostMapping("login")
    public User login(@RequestBody User user){
        User res = userService.login(user.getUsername(), user.getPassword());
        if (res == null) {
            log.info("用户名或密码错误，请重新输入");
        }
        return res;
    }
}
