package com.example.springbootmybatis2.mapper;

import com.example.springbootmybatis2.model.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Copyright (C), 2018-2021
 * @FileName: RoleMapper
 * @Author: Charles
 * @Date: 2021/2/10 21:08
 * @Description: review for working
 */
@Mapper
public interface RoleMapper {
    /**
     * 参照清理缓存
     * begin---------------------------
     * @param id
     * @return
     */
    SysRole selectRoleById(Long id);

    int updateRoleById(SysRole sysRole);
    /**
     *end -----------------------------------
     */
}
