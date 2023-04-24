package com.he.service;

import com.he.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    User findUserById(Integer id);

    User findUserByName(String username);

    User login(String username,String password);

    List<Map<String, User>> selectMaps();
}
