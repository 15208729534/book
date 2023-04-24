package com.he.mapper;

import com.he.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    List<Role> findRolesByUserId(Integer userId);
}