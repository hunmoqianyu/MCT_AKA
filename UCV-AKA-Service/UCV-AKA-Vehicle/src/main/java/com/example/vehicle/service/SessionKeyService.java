package com.example.vehicle.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.entity.SessionKey;

/**
 * (SessionKey)表服务接口
 *
 * @author makejava
 * @since 2024-05-15 15:45:04
 */
public interface SessionKeyService extends IService<SessionKey> {


    void insert(SessionKey key);

    SessionKey getMaxKeyIdRecord();
}

