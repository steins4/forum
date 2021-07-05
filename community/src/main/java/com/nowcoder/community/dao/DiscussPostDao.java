package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostDao {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit,int orderMode);

    //@Param 给参数取别名
    // 如果参数只有一个，并且在《if》里使用，必须加别名
    int selectDiscussPostRows(@Param("userId")int userId);

    int insertDiscussPost(DiscussPost discussPost);

    // 查询帖子详情
    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id, int commentCount);

    int updateType(int id, int type);

    int updateStatus(int id, int status);

    int updateScore(int id, double score);
}