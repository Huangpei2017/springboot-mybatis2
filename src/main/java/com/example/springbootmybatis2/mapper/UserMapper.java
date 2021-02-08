package com.example.springbootmybatis2.mapper;


import com.example.springbootmybatis2.model.SysRole;
import com.example.springbootmybatis2.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
	


	/**
	 * 查询全部用户
	 * 
	 * @return
	 */
	List<SysUser> selectAll();

	/**
	 * 根据用户 id 获取角色信息.
	 *
	 * @param userId
	 * @return
	 */
	List<SysRole> selectRolesByUserId(Long userId);
	

	int insert2(SysUser sysUser);

	int insert3(SysUser sysUser);

	int update1(SysUser sysUser);

	List<SysRole> selectRolesByUserAndRole(@Param("user1") SysUser sysUser, @Param("role1") SysRole sysRole);
}
