package com.he.mapper;

import com.he.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    User findUserById(Integer id);

    User findUserByName(String username);

    List<Map<String, User>> selectMaps();

    User login(String username, String password);
}
