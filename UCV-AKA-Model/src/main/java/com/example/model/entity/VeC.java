package com.example.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (VeC)实体类
 *
 * @author makejava
 * @since 2024-05-12 14:53:41
 */
@Data
public class VeC implements Serializable {
    private static final long serialVersionUID = 631743831766874390L;
    /**
     * 车牌号
     */
    private String vid;
    /**
     * 车辆和云端的会话密钥
     */
    private String vk;


    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

}

