package com.example.model.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Card)实体类
 *
 * @author makejava
 * @since 2024-05-12 14:53:37
 */
@Data
public class Card implements Serializable {
    private static final long serialVersionUID = 824207055558292139L;
    
    private String cardId;
    /**
     * 参数a
     */
    private String paraA;
    /**
     * 参数b
     */
    private String paraB;
    /**
     * 参数c
     */
    private String paraC;
    /**
     * 云端公钥S
     */
    private String pubKeyS;
    /**
     * 生物模板密钥
     */
    private String tp;


    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
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

    public String getParaC() {
        return paraC;
    }

    public void setParaC(String paraC) {
        this.paraC = paraC;
    }

    public String getPubKeyS() {
        return pubKeyS;
    }

    public void setPubKeyS(String pubKeyS) {
        this.pubKeyS = pubKeyS;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

}

