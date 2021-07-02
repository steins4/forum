package com.nowcoder.community.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * login_ticket
 * @author 
 */
@Data
public class LoginTicket implements Serializable {
    private int id;

    private int userId;

    private String ticket;

    /**
     * 0-有效; 1-无效;
     */
    private int status;

    private Date expired;

    private static final long serialVersionUID = 1L;
}