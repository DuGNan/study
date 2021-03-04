package com.dgn.service;

import com.dgn.entity.SysUser;

public interface AuthService {
    SysUser getUser(String username);

    
}
