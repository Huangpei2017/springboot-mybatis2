package com.example.springbootmybatis2.mapper;

import com.example.springbootmybatis2.model.SysRole;
import com.example.springbootmybatis2.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Copyright (C), 2018-2021
 * @FileName: UserMapper2
 * @Author: Charles
 * @Date: 2021/2/9 8:48
 * @Description: review for working
 */
@Mapper
public interface UserMapper2 {

    @SelectProvider(type = UserProvider.class,method = "selectRolesByUserId")
    List<SysRole> selectRolesByUserId(Long userId);



    @InsertProvider(type = UserProvider.class,method = "insert2")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert2(SysUser sysUser);

    @InsertProvider(type = UserProvider.class,method = "insert2")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",resultType = Long.class,before = false)
    int insert3(SysUser sysUser);

}
