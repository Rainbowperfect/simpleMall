package org.mall;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mall.mapper.UserMapper;
import org.mall.pojo.User;

import java.io.InputStream;

public class TestUserMapper {


    private SqlSessionFactory sqlSessionFactory;

    @Before
    public  void  setUp() throws Exception {
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = builder.build(inputStream);
    }

    @Test
    public void QueryUserById(){
        SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.queryUserById(2L);
        System.out.println(user.toString());
        sqlSession.close();
    }

    // @Test
    // public void insertUser() throws Exception {
    //     SqlSession sqlSession = sqlSessionFactory.openSession(true);
    //     //获取userMapper代理实现
    //     UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
    //     User user =new User();
    //     user.setAge(22);
    //     user.setBirthday(new Date());
    //     user.setCreated(user.getBirthday());
    //     user.setName("张飞阳");
    //     user.setPassword("45455");
    //     user.setSex(1);
    //     user.setUserName("张三丰");
    //     user.setUpdated(new Date());
    //
    //     usermapper.saveUser(user);
    //
    //     sqlSession.close();
    // }
}
