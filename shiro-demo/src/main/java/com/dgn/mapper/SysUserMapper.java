package com.dgn.mapper;
import org.apache.ibatis.annotations.Param;

import com.dgn.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface SysUserMapper {
    SysUser selectOneByUsername(@Param("username")String username);


}