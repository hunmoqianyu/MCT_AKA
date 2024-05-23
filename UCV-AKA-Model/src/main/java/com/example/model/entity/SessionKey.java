package com.example.model.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * (SessionKey)表实体类
 *
 * @author makejava
 * @since 2024-05-16 11:15:23
 */
@SuppressWarnings("serial")
public class SessionKey extends Model<SessionKey> {
    
    private Integer keyId;
    //sessionkey的值
    private String value;
    
    private String userId;
    
    private String vid;


    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    protected Serializable pkVal() {
        return this.keyId;
    }
    }

