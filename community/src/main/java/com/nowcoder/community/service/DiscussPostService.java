package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostDao;
import com.nowcoder.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostDao discussPostDao;

    /**
     * 查询首页帖子
     * @param userId 用户id
     * @param offset 偏移量
     * @return
     */
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit) {
        return discussPostDao.selectDiscussPosts(userId, offset, limit);
    }

    /**
     * 查询用户帖子数量
     * @param userId
     * @return
     */
    public int findDiscussPostsRows(int userId) {
        return discussPostDao.selectDiscussPostRows(userId);
    }
}
