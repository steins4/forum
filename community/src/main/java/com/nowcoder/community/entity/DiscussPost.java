package com.nowcoder.community.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * discuss_post
 * @author 
 */
@Data
public class DiscussPost implements Serializable {
    private int id;

    private int userId;

    /**
     * 帖子标题
     */
    private String title;

    private String content;

    /**
     * 0-普通; 1-置顶;
     */
    private int type;

    /**
     * 0-正常; 1-精华; 2-拉黑;
     */
    private int status;

    private Date createTime;

    /**
     * 评论数量
     */
    private int commentCount;

    private double score;

    private static final long serialVersionUID = 1L;

}