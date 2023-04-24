package com.he.service;

import java.util.List;

public interface RoleService {

    List<RoleService> findRolesByUserId(Integer userId);
}
