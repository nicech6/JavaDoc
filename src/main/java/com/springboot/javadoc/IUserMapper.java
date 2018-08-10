package com.springboot.javadoc;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserMapper {
    @Select("select * from user")
    List<UserInfo> getAll();
}
