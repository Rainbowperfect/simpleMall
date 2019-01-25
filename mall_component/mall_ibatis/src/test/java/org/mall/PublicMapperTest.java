package org.mall;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mall.mapper.PublicMapper;
import org.mall.pojo.User;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class PublicMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = builder.build(resource);
    }

    /**
     * 通过条件查询
     *  SELECT SEX,NAME,BIRTHDAY,UPDATED,ID,CREATED,USER_NAME USERNAME,PASSWORD,AGE FROM user WHERE (ID = ? )
     */
    @Test
    public void selectByPrimaryKeyTest() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        User user = new User();
        //  user.setId(1L);
        User user1 = mapper.selectByPrimaryKey(user);
        System.out.println(user1);
        sqlSession.close();
    }

    /**
     * selectOne如果查询的结果超过2个，就会抛出异常
     *  SELECT SEX,NAME,BIRTHDAY,UPDATED,ID,CREATED,USER_NAME USERNAME,PASSWORD,AGE FROM user WHERE ID = ?
     */
    @Test
    public void selectOne() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        User user1 = new User();
        user1.setId(2L);
        User user = mapper.selectOne(user1);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     * 如果不传入条件就会为null,
     * 类似于如下：
     * SELECT COUNT(*) FROM user
     */
    @Test
    public void selectCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        User user = new User();
        mapper.selectCount(user);
        user.setAge(18);
        System.out.println(user);
        sqlSession.close();
    }

    /**
     *     SELECT * FROM `user` LIMIT ?, ?;
     */
    @Test
    public void GetPage() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);
        HashMap<String,Integer> map=new HashMap<>();
        map.put("page",0);
        map.put("rows",1000);
        List<User> users = mapper.getPage(map);
        for (User user : users) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    /**
     * 使用通用mapper的pageHelp去分页
     */
    @Test
    public void PageHelp(){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        PublicMapper mapper = sqlSession.getMapper(PublicMapper.class);

        Page page = PageHelper.startPage(0, 1);
        System.out.println(page);

        List<User> list = mapper.select(null);

        for (User user : list) {
            System.out.println(user);
        }
        //分页查询的信息
        PageInfo<User> userPageInfo = new PageInfo<>(list);
        long total = userPageInfo.getTotal();
        int pages = userPageInfo.getPages();
        System.out.println(total+"===="+pages);

        sqlSession.close();
    }
}
