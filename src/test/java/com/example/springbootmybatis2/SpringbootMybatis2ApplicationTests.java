package com.example.springbootmybatis2;

import com.example.springbootmybatis2.mapper.CountryMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootMybatis2ApplicationTests {
	@Resource
	CountryMapper countryMapper;

	private static SqlSessionFactory sqlSessionFactory;

	@Test
	void contextLoads() {
	}

	@Test
	void test1(){
		countryMapper.selectAll();
	}



}
