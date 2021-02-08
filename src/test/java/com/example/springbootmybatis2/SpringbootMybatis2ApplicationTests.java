package com.example.springbootmybatis2;

import com.example.springbootmybatis2.mapper.CountryMapper;
import com.example.springbootmybatis2.mapper.UserMapper;
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
import java.util.Date;
import java.util.List;

@SpringBootTest
class SpringbootMybatis2ApplicationTests {
	@Resource
	CountryMapper countryMapper;
	@Resource
	UserMapper userMapper;

	private static SqlSessionFactory sqlSessionFactory;

	@Test
	void contextLoads() {
	}

	@Test
	void test1(){
		countryMapper.selectAll();
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


}
