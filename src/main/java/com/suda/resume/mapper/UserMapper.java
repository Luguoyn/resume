package com.suda.resume.mapper;

import com.suda.resume.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("SELECT * from user where username = #{username}")
    User getUserByName(String username);

    @Update("UPDATE user SET password = #{password} WHERE username = #{username}")
    int update(User user);
}
