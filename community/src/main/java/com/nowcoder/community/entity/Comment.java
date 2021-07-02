package com.nowcoder.community.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * comment
 * @author 
 */
@Data
public class Comment implements Serializable {
    private int id;

    private int userId;

    private int entityType;

    private int entityId;

    private int targetId;

    private String content;

    private int status;

    private Date createTime;

    private static final long serialVersionUID = 1L;
}