package com.example.model.entity;

import java.util.Date;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (Message)表实体类
 *
 * @author makejava
 * @since 2024-05-16 16:09:44
 */
@SuppressWarnings("serial")
public class Message extends Model<Message> {
    
    private Integer messageId;
    
    private Integer keyId;
    
    private String content;
    //消息发送时间
    private Date date;
    //状态1是用户端发送，状态2是车连端发送
    private Integer status;


    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.messageId;
    }
    }

