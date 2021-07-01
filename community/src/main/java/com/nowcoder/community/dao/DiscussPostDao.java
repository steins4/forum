package com.nowcoder.community.dao;

import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostDao {
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param 给参数取别名
    // 如果参数只有一个，并且在《if》里使用，必须加别名
    int selectDiscussPostRows(@Param("userId")int userId);
}