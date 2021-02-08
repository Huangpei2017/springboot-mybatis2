package com.example.springbootmybatis2.mapper;


import com.example.springbootmybatis2.model.SysRole;
import com.example.springbootmybatis2.model.SysUser;
import org.apache.ibatis.annotations.*;

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


	@Select({"SELECT id, user_name userName, user_password userPassword,  " +
			"  user_email userEmail, user_info userInfo," +
			" head_img headImg," +
			"  create_time createTime","from sys_user"})
	List<SysUser> selectAll2();

	@Results(id="sysUserMap",value = {
			@Result(property = "id",column = "id",id=true),
			@Result(property = "userName",column = "user_name"),
			@Result(property = "userPassword",column = "user_password"),
			@Result(property = "userEmail",column = "user_email"),
			@Result(property = "userInfo",column = "user_info"),
			@Result(property = "headImg",column = "head_img"),
			@Result(property = "createTime",column = "create_time")

	})
	@Select({"select id,user_name,user_password,user_email,user_info,head_img,create_time "," from sys_user"})
	List<SysUser> selectAll3();


	@ResultMap("sysUserMap")
	@Select("select * from sys_user")
	List<SysUser> selectAll4();

	@Insert({"insert into sys_user(user_name,user_password,user_email,user_info,head_img,create_time)","values(#{userName},#{userPassword}" +
			",#{userEmail},#{userInfo},#{headImg,jdbcType=BLOB},#{createTime,jdbcType=TIMESTAMP})"})
	@Options(useGeneratedKeys = true,keyProperty = "id")
	int insert22(SysUser sysUser);

	@Insert({"insert into sys_user(user_name,user_password,user_email,user_info,head_img,create_time)","values(#{userName},#{userPassword}" +
			",#{userEmail},#{userInfo},#{headImg,jdbcType=BLOB},#{createTime,jdbcType=TIMESTAMP})"})
	@SelectKey(statement = "SELECT LAST_INSERT_ID()",keyProperty = "id",resultType = Long.class, before = false)
	int insert23(SysUser sysUser);
	
	
	@Update({"update sys_user\n" +
			" set user_name = #{userName}\n" +
			"  where id = #{id}"})
	int update12(SysUser sysUser);

}
