package com.he.service;

import com.he.entity.Orders;

public interface OrdersService {

    /**
     * 根据id查询订单信息，要求将订单的用户信息也查询出来
     * @param id
     * @return
     */
    Orders findOrdersById(Integer id);
}
