package com.nowcoder.community.service;

import com.nowcoder.community.dao.DiscussPostDao;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.util.CommunityUtil;
import com.nowcoder.community.util.SensitiveFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostDao discussPostDao;

    @Autowired
    private SensitiveFilter filter;


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

    public int addDiscussPost(DiscussPost post) {
        if (post == null) {
            throw new IllegalArgumentException("参数不能为null");
        }
        //转义html
        post.setTitle(HtmlUtils.htmlEscape(post.getTitle()));
        post.setContent(HtmlUtils.htmlUnescape(post.getContent()));

        // 过滤敏感词
        post.setTitle(filter.filter(post.getTitle()));
        post.setContent(filter.filter(post.getContent()));
        return discussPostDao.insertDiscussPost(post);
    }

    public DiscussPost findDiscussPostById(int id) {
        return discussPostDao.selectDiscussPostById(id);
    }

    public int updateCommentCount(int id, int commentCount) {
        return discussPostDao.updateCommentCount(id, commentCount);
    }
}
