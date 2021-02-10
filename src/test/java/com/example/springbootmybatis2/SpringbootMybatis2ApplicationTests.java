package com.example.springbootmybatis2;

import com.example.springbootmybatis2.mapper.CountryMapper;
import com.example.springbootmybatis2.mapper.UserMapper;
import com.example.springbootmybatis2.mapper.UserMapper2;
import com.example.springbootmybatis2.model.SysPrivilege;
import com.example.springbootmybatis2.model.SysRole;
import com.example.springbootmybatis2.model.SysUser;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.tomcat.util.security.MD5Encoder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import sun.security.provider.MD5;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
class SpringbootMybatis2ApplicationTests {
	@Resource
	CountryMapper countryMapper;
	@Resource
	UserMapper userMapper;
	@Resource
	UserMapper2 userMapper2;

	private static SqlSessionFactory sqlSessionFactory;

	@Test
	void contextLoads() {
	}

	@Test
	void test1(){
//		countryMapper.selectAll();
		userMapper.selectAll();
	}

	@Test
	void test2(){
		List<SysRole> sysRoleList = userMapper.selectRolesByUserId(1L);
		System.out.println(sysRoleList.get(0));
		System.out.println(sysRoleList.get(1));
	}

	/***
	 *  当需要提供id回写的时候如何使用,获取插入数据记录的id
	  *
	 * @author Charles
	 * @date 2021/2/8 16:07
	 * @return void
	 */
	@Test
	void test3(){
		SysUser sysUser = new SysUser();
		sysUser.setUserName("test3");
		sysUser.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
		sysUser.setUserEmail("test@qq.com");
		sysUser.setUserInfo("test33");
		sysUser.setHeadImg(new byte[]{1,2,3,4});
		sysUser.setCreateTime(new Date());
		int result = userMapper.insert2(sysUser);
		System.out.println(result);
		System.out.println(sysUser.getId());


	}
	/***
	 *  如何，当需要获取主键id，数据库不提供主键id自增的时候
	  *
	 * @author Charles
	 * @date 2021/2/8 16:17
	 * @return void
	 */
	@Test
	void test4(){
		SysUser sysUser = new SysUser();
		sysUser.setUserName("test4");
		sysUser.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
		sysUser.setUserEmail("test@qq.com");
		sysUser.setUserInfo("test44");
		sysUser.setHeadImg(new byte[]{1,2,3,4});
		sysUser.setCreateTime(new Date());
		int result = userMapper.insert3(sysUser);
		System.out.println(result);
		System.out.println(sysUser.getId());


	}
	/***
	 *  review for working
	  * update 使用
	 * @author Charles
	 * @date 2021/2/8 16:35
	 * @return void
	 */
	@Test
	void test5(){
		SysUser sysUser  = new SysUser();
		sysUser.setUserName("change2");
		sysUser.setId(1035L);
		int n =userMapper.update1(sysUser);
		System.out.println(n);
		System.out.println(sysUser.getUserName());
	}
	/***
	 *  review for working
	  * select 传多个参数的方式
	 * @author Charles
	 * @date 2021/2/8 16:46
	 * @return void
	 */
	@Test
	void test6(){
		SysUser sysUser = new SysUser();
		sysUser.setId(1L);
		SysRole sysRole = new SysRole();
		sysRole.setEnabled(1);
		List<SysRole > sysRoles= userMapper.selectRolesByUserAndRole(sysUser,sysRole);
		System.out.println(sysRoles.size());
	}
	/***
	 *  review for working
	  * mybatis 注解的使用方式
	 * @author Charles
	 * @date 2021/2/8 16:56
	 * @return void
	 */
    @Test
	void test11(){
		List<SysUser> sysUsers = userMapper.selectAll2();
		System.out.println(sysUsers.size());

	}
	//mybatis 注解的使用方式
	@Test
	void test12(){
		List<SysUser> sysUsers=userMapper.selectAll3();
		System.out.println(sysUsers.size());


	}

	/**
	 * mybatis 注解的使用方式
	 */
	@Test
	void test13(){
		List<SysUser> sysUsers=userMapper.selectAll4();
		System.out.println(sysUsers.size());
	}
	@Test
	void test14(){
		SysUser sysUser = new SysUser();
		sysUser.setUserName("test14");
		sysUser.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
		sysUser.setUserEmail("test14@qq.com");
		sysUser.setUserInfo("test14");
		sysUser.setHeadImg(new byte[]{1,2,3,4});
		sysUser.setCreateTime(new Date());
		int n=userMapper.insert22(sysUser);
		System.out.println(n);
		System.out.println(sysUser.getId());
	}
	/***
	 *  review for working
	  * 返回非自增主键。mysql里面这相当于回查。
	 * @author Charles
	 * @date 2021/2/8 17:25
	 * @return void
	 */
	@Test
	void test15(){
		SysUser sysUser = new SysUser();
		sysUser.setUserName("test15");
		sysUser.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
		sysUser.setUserEmail("test14@qq.com");
		sysUser.setUserInfo("test15");
		sysUser.setHeadImg(new byte[]{1,2,3,4});
		sysUser.setCreateTime(new Date());
		int n=userMapper.insert23(sysUser);
		System.out.println(n);
		System.out.println(sysUser.getId());
	}

	@Test
	void test16(){
		SysUser sysUser  = new SysUser();
		sysUser.setUserName("change2");
		sysUser.setId(1040L);
		int n =userMapper.update12(sysUser);
		System.out.println(n);
		System.out.println(sysUser.getUserName());
	}


	/**
	 * 测试 Provider的用法
	 */
	@Test
	void test21(){
		List<SysRole> sysRoleList = userMapper2.selectRolesByUserId(1L);
		System.out.println(sysRoleList.size());

	}

	@Test
	void test22(){
		SysUser sysUser = new SysUser();
		sysUser.setUserName("test22");
		sysUser.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
		sysUser.setUserEmail("test@qq.com");
		sysUser.setUserInfo("test22");
		sysUser.setHeadImg(new byte[]{1,2,3,4});
		sysUser.setCreateTime(new Date());
		int nn =userMapper2.insert2(sysUser);
		System.out.println(nn);
		System.out.println(sysUser.getId());
	}

	@Test
	void test23(){
		SysUser sysUser = new SysUser();
		sysUser.setUserName("test23");
		sysUser.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
		sysUser.setUserEmail("test@qq.com");
		sysUser.setUserInfo("test22");
		sysUser.setHeadImg(new byte[]{1,2,3,4});
		sysUser.setCreateTime(new Date());
		int nn =userMapper2.insert3(sysUser);
		System.out.println(nn);
		System.out.println(sysUser.getId());
	}
	/***
	 *  review for working
	  * 动态sql查询
	 * @author Charles
	 * @date 2021/2/9 10:04
	 * @return void
	 */
	@Test
	void test31(){
		SysUser sysUser1 = new SysUser();
		sysUser1.setUserName("test4");

		userMapper.selectByUser(sysUser1);
	}

@Test
	void test32(){
		SysUser sysUser =new SysUser();
		sysUser.setId(1036L);
		sysUser.setUserName("change32");
		sysUser.setUserEmail("change32@163.com");
		userMapper.updateByUser(sysUser);
	}
@Test
	void test33(){
		SysUser sysUser = new SysUser();
//		sysUser.setId(1036L);
//		sysUser.setUserName("change32");
		List<SysUser> sysUsers =userMapper.selectByIdOrUserName(sysUser);
		System.out.println(sysUsers.size());
	}

	/**
	 * 动态sql insert
	 */
	@Test
	void  test34(){
		SysUser sysUser  = new SysUser();
		sysUser.setUserName("test34");
//		sysUser.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
//		sysUser.setUserEmail("test34@qq.com");
		sysUser.setUserInfo("test34");
		sysUser.setHeadImg(new byte[]{1,2,3,4});
		sysUser.setCreateTime(new Date());
		int  n =userMapper.insert5(sysUser);
		System.out.println(n);
		System.out.println(sysUser.getId());
	}

	/**
	 * 动态sql  foreach
	 */
	@Test
	void test35(){
		int[] ids = new int[]{1,2,3};
		List<SysUser> sysUsers = userMapper.selectByIdList(ids);
		System.out.println(sysUsers.size());


	}
	@Test
	void test36(){
		List<Integer> ids = Arrays.asList(1,2,3);
		List<SysUser> sysUsers = userMapper.selectByIdList2(ids);
		System.out.println(sysUsers.size());
	}
	@Test
	void test37(){
		SysUser sysUser  = new SysUser();
		sysUser.setUserName("test34");
		sysUser.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
		sysUser.setUserEmail("test34@qq.com");
		sysUser.setUserInfo("test34");
		sysUser.setHeadImg(new byte[]{1,2,3,4});
		sysUser.setCreateTime(new Date());
		SysUser sysUser2  = new SysUser();
		sysUser2.setUserName("test34");
		sysUser2.setUserPassword(MD5Encoder.encode(new byte[]{1,2,3,4,5,6}));
		sysUser2.setUserEmail("test34@qq.com");
		sysUser2.setUserInfo("test34");
		sysUser2.setHeadImg(new byte[]{1,2,3,4});
		sysUser2.setCreateTime(new Date());
		List<SysUser> sysUserList = new ArrayList<>();
				Collections.addAll(sysUserList,sysUser,sysUser2);
		int n =userMapper.insertList(sysUserList);
		System.out.println(n);
		System.out.println(sysUserList.get(0).getId());
	}
@Test
	void test38(){
		SysUser sysUser = new SysUser();
		sysUser.setUserName("test34");
		List<SysUser> sysUserList =userMapper.selectByUser2(sysUser);
		System.out.println(sysUserList.size());
	}
	/***
	 *  review for working
	  * 一一映射
	 * @author Charles
	 * @date 2021/2/9 15:10
	 * @return void
	 */
@Test
	void test41(){

		List<SysUser> sysUsers =userMapper.selectUserAndRoleById(1L);
		System.out.println(sysUsers.size());
	System.out.println(sysUsers.get(0).getRole().getRoleName()+"||"+sysUsers.get(0).getRole().getEnabled());
	}

	/**
	 * 一一映射  使用嵌套对象 ，resultMap实现
	 */
	@Test
	void test42(){
		List<SysUser> sysUsers = userMapper.selectUserAndRoleById2(1L);
		System.out.println(sysUsers.get(0).getRole().getRoleName() +"||"+ sysUsers.get(0).getRole().getEnabled());
	}

	/**
	 * 一一映射 ，使用resultMap 延迟加载实现。
	 */
	@Test
	void test43(){

		List<SysUser> sysUserList = userMapper.selectUserAndRoleByIdSelect(1L);
		System.out.println(sysUserList.size());
		SysRole sysRole = sysUserList.get(0).getRole();
		System.out.println(sysRole.getRoleName()+"||"+ sysRole.getEnabled());

	SysRole sysRole2 = sysUserList.get(1).getRole();
	System.out.println(sysRole2.getRoleName()+"||"+ sysRole2.getEnabled()+"||"+sysRole2.getCreateInfo().getCreateBy()+"||"+sysRole2.getCreateInfo().getCreateTime());

	}

	/**
	 * 一对多结果，使用resultMap实现。合并子结果集
	 */
	@Test
	void test44(){
		List<SysUser> sysUserList = userMapper.selectAllUserAndRoles();
		System.out.println(sysUserList.size());
		System.out.println(sysUserList.get(0).getRoleList().size());
	}

	/**
	 * 使用resultMap 实现一对多 再对多 的三重映射结果集查询。合并数据
	 */
	@Test
	void test45(){
		List<SysUser> sysUserList = userMapper.selectAllUserAndRoles2();
		System.out.println(sysUserList.size());
		List<SysRole> sysRoleList = sysUserList.get(0).getRoleList();
		System.out.println(sysRoleList.size());
		List<SysPrivilege> sysPrivilegeList = sysRoleList.get(1).getPrivilegeList();
		System.out.println(sysPrivilegeList.size());
	}
	/**
	 * 使用resultMap 实现一对多 再对多 的三重映射结果集查询。 然后是延迟加载实现
	 */
@Test
	void test46(){
		List<SysUser> sysUserList= userMapper.selectAllUserAndRoles3();
		System.out.println("sysUserList size="+sysUserList.size());
		SysUser sysUser0 = sysUserList.get(0);
		List<SysRole> roleList =sysUser0.getRoleList();
		System.out.println("username:"+sysUser0.getUserName()+"|| roleList size="+ sysUser0.getRoleList().size());
		SysRole sysRole0 = roleList.get(0);
		List<SysPrivilege> privileges = sysRole0.getPrivilegeList();
		System.out.println("roleName:"+sysRole0.getRoleName()+"|| privileges size="+sysRole0.getPrivilegeList().size());
	}
@Test
	void test47(){
		List<SysRole> roleList = userMapper.selectRoleListByUserId2(1L);
		System.out.println(roleList.size());

		System.out.println("privilegeList："+roleList.get(0).getPrivilegeList());
		System.out.println("privilegeList:"+roleList.get(1).getPrivilegeList());
//		System.out.println("privilegeList:"+roleList.get(2).getPrivilegeList());
	}

	/**
	 * 调用存储过程。 返回一条结果。
	 */
	@Test
	void test51(){
	SysUser sysUser = new SysUser();
	sysUser.setId(1L);
	 userMapper.selectUserInfoById(sysUser);
		System.out.println(sysUser.getUserName()+"||" + sysUser.getUserEmail());
	}

	/**
	 * 调用存储过程， 返回结果集，失败。
	 */
	@Test
	void test52(){
	Map<String,Object> param = new HashMap<>();
	param.put("userName","admin");
	param.put("_offset",1);
	param.put("_limit",10);


	List<SysUser> sysUserList = userMapper.selectUserPage(param);
		System.out.println("total:"+param.get("total"));
		System.out.println("size:"+sysUserList.size());
//		System.out.println("size:"+sysUserList.size()+"||username0="+sysUserList.get(0).getUserName());
	}




}
