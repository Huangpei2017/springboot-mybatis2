package com.example.springbootmybatis2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Copyright (C), 2018-2021
 * @FileName: TodayConfiguration
 * @Author: Charles
 * @Date: 2021/1/20 22:19
 * @Description: 第21章并发 练习【】
 */
@MapperScan("com.example.springbootmybatis2.mapper")
@Configuration
public class TodayConfiguration {

}
