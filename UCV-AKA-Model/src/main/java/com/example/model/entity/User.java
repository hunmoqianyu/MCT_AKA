package com.example.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2024-05-12 14:53:41
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -30977609372703719L;
    
    private String username;
    
    private String password;
    
    private String bio;
    /**
     * 智能卡号
     */
    private String cardId;
    /**
     * 车牌号
     */
    private String vid;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

}

