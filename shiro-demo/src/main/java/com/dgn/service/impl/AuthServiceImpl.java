package com.dgn.service.impl;

import com.dgn.entity.SysUser;
import com.dgn.mapper.SysUserMapper;
import com.dgn.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 杜广楠
 * @Description
 * @Date 2/23/2021 4:57 PM
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(String username) {
        return sysUserMapper.selectOneByUsername(username);
    }
}
