package com.he.service.impl;

import com.he.entity.Orders;
import com.he.mapper.OrdersMapper;
import com.he.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper orderMapper;

    @Override
    public Orders findOrdersById(Integer id) {
        return orderMapper.findOrdersById(id);
    }
}
