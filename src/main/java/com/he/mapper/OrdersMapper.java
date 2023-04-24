package com.he.mapper;

import com.he.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrdersMapper {

    Orders findOrdersById(Integer id);
}