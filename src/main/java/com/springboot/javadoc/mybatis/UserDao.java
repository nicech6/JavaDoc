package com.springboot.javadoc.mybatis;

import com.springboot.javadoc.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    void insertUser(UserInfo userInfo);

    UserInfo findById(int id);

    List<UserInfo> findAllUser();

    void delete(int id);

    void updateName(@Param("id") int id, @Param("name") String name);

    void mulitSelector(@Param("money") String money, @Param("name") String name);
}
