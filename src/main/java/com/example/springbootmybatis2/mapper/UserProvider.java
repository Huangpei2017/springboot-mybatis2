package com.example.springbootmybatis2.mapper;

import com.example.springbootmybatis2.model.SysRole;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

/**
 * @Copyright (C), 2018-2021
 * @FileName: UserProvider
 * @Author: Charles
 * @Date: 2021/2/9 8:49
 * @Description: review for working
 */

public class UserProvider {

   public String selectRolesByUserId(Long userId){
       return new SQL(){
           {
               SELECT("r.id," +
                       "r.role_name roleName," +
                       "r.enabled," +
                       "r.create_by createBy," +
                       "r.create_time createTime," +
                       "u.user_name as \"user.userName\"," +
                       "u.user_email as \"user.userEmail\"");
               FROM("sys_user u");
               INNER_JOIN("sys_user_role ur on u.id = ur.user_id",
                       "sys_role r on ur.role_id = r.id");
               WHERE(" u.id = #{userId}");

           }
       }.toString();
   }

   public String insert2(){
       return new SQL(){
           {
               INSERT_INTO("sys_user");
               VALUES("user_name","#{userName}");
               VALUES("user_password","#{userPassword}");
               VALUES("user_email,user_info, head_img, create_time",
                       "#{userEmail},#{userInfo}, #{headImg, jdbcType=BLOB}, #{createTime, jdbcType=TIMESTAMP}");
           }
       }.toString();
   }


}
