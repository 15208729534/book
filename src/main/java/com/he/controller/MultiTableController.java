package com.he.controller;

import com.he.entity.Orders;
import com.he.entity.User;
import com.he.service.OrdersService;
import com.he.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiTableController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private UserService userService;

    /**
     * 根据订单id查询订单，要求把下单用户的信息也查询出来
     */
    @GetMapping("/findOrdersById/{id}")
    private Orders findOrdersById(@PathVariable("id") Integer id){
        return ordersService.findOrdersById(id);
    }

    /**
     * 根据用户id查询用户信息，要求把用户所拥有的角色信息也查询出来
     */
    @GetMapping("/findUserById/{id}")
    private User findUserById(@PathVariable("id") Integer id){
        return userService.findUserById(id);
    }

    /**
     * 根据用户名查询用户信息，要求把用户所拥有的角色信息也查询出来
     */
    @GetMapping("/findUserByName")
    private User findUserById(@Param("username") String username){
        return userService.findUserByName(username);
    }
}
