package com.example.springbootmybatis2;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.Properties;

/**
 * @Copyright (C), 2018-2021
 * @FileName: TodayConfiguration
 * @Author: Charles
 * @Date: 2021/1/20 22:19
 * @Description: mybatis cconfigure 配置。
 */
@MapperScan("com.example.springbootmybatis2.mapper")
@Configuration
public class TodayConfiguration {


    @Bean
    public DatabaseIdProvider getDatabaseIdProvider(){
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();

        Properties properties = new Properties();
        properties.setProperty("Oracle","oracle");
        properties.setProperty("DB2","db2");
        properties.setProperty("MySQL","mysql");
        databaseIdProvider.setProperties(properties);
        return databaseIdProvider;
    }



}
