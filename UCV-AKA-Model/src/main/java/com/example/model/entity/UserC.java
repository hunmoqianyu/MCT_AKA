package com.example.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (UserC)实体类
 *
 * @author makejava
 * @since 2024-05-12 14:53:41
 */
@Data
public class UserC implements Serializable {
    private static final long serialVersionUID = 977739191299807761L;
    
    private String userId;
    /**
     * 随机数r
     */
    private String r;
    /**
     * 云端私钥s
     */
    private String priKeyS;
    /**
     * 参数a
     */
    private String paraA;
    /**
     * 参数b
     */
    private String paraB;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public String getPriKeyS() {
        return priKeyS;
    }

    public void setPriKeyS(String priKeyS) {
        this.priKeyS = priKeyS;
    }

    public String getParaA() {
        return paraA;
    }

    public void setParaA(String paraA) {
        this.paraA = paraA;
    }

    public String getParaB() {
        return paraB;
    }

    public void setParaB(String paraB) {
        this.paraB = paraB;
    }

}

