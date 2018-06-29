package com.springboot.swgger.mybatis;

import com.springboot.swgger.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public UserInfo userInfo(int id) {
        SqlSession sqlSession = getSession();
        userDao = sqlSession.getMapper(UserDao.class);
        UserInfo byId = userDao.findById(id);
        return byId;
    }

    public List<UserInfo> getUserList() {
        SqlSession sqlSession = getSession();
        userDao = sqlSession.getMapper(UserDao.class);
        List<UserInfo> allUser = userDao.findAllUser();
        return allUser;
    }

    public void insertUser(int id, String name, String money) {
        SqlSession sqlSession = getSession();
        userDao = sqlSession.getMapper(UserDao.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setName(name);
        userInfo.setMoney(money);
        userInfo.setId(id);
        userDao.insertUser(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

    public void delete(int id) {
        SqlSession sqlSession = getSession();
        userDao = sqlSession.getMapper(UserDao.class);
        userDao.delete(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(int id, String name) {
        SqlSession sqlSession = getSession();
        userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateName(id, name);
//        UserInfo userInfo=userDao.findById(id);
//        userInfo.setName(name);
//        userDao.updateName(userInfo);
        sqlSession.commit();
        sqlSession.close();
    }

//    public List<UserInfo>  muiltSele(String money, String name) {
//        SqlSession sqlSession = getSession();
//        userDao = sqlSession.getMapper(UserDao.class);
//        userDao.mulitSelector(money, name);
//        sqlSession.commit();
//        sqlSession.close();
//        /List<UserInfo> allUser=userDao.insertUser();
//        return allUser;
//    }

    public SqlSession getSession() {
        SqlSession sqlSession = null;
        String resource = "configuration.xml";
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource)).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
