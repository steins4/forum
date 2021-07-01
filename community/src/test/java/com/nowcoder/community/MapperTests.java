package com.nowcoder.community;


import com.nowcoder.community.dao.DiscussPostDao;
import com.nowcoder.community.dao.UserDao;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;


@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserDao userDao;

    @Autowired
    private DiscussPostDao discussPostDao;

    @Test
    public void testSelectUser() {
        User user = userDao.selectById(1);
        User user1 = userDao.selectByEmail("nowcoder1@sina.com");
        User user2 = userDao.selectByName("SYSTEM");
        System.out.println("user"+user);
        System.out.println("user1"+user1);
        System.out.println("user2"+user2);
    }

    @Test
    public void TestInsertUser() {
        User user = new User();
        user.setCreateTime(new Date());
        user.setHeaderUrl("12");
        user.setPassword("123");
        user.setSalt("we");
        user.setEmail("dijhd");
        user.setActivationCode("fdhhs");
        user.setUsername("wbe");
        user.setStatus(1);
        user.setType(2);
        int i = userDao.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void testUpdateUser() {
        System.out.println(userDao.updateHeader(151, "wwwwwwwwwww"));
        System.out.println(userDao.updatePassword(151, "2222222222"));
        System.out.println(userDao.updateStatus(151, 112));
    }

    @Test
    public void testSelectPosts() {
        List<DiscussPost> discussPosts = discussPostDao.selectDiscussPosts(101, 0, 100);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost);
        }

        int rows = discussPostDao.selectDiscussPostRows(101);
        System.out.println(rows);
    }

}
