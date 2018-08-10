package com.springboot.javadoc.mybatis;

import com.springboot.javadoc.IUserMapper;
import com.springboot.javadoc.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class UserDaoTest {

    @Test
    public void test(){
        for (int i = 10249; i < 10250; i--) {
           int s = (i % 3600) % 60;
           System.out.print(s+"/n");
        }
    }

    public void findById() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
//        List<UserInfo> allUser = userDao.findAllUser();
        UserInfo byId = userDao.findById(1);
        //org.junit.Assert.assertNotNull("没找到数据", allUser);
        System.out.print(byId.getName());
    }

    // Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    public static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

    public void IgetMapper() {
        IUserMapper iUserMapper = getSessionFactory().openSession().getMapper(IUserMapper.class);
        List<UserInfo> all = iUserMapper.getAll();
        System.out.print(all);
    }
}
