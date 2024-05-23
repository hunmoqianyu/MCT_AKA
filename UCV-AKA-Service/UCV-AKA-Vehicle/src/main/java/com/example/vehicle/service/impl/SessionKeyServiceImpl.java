package com.example.vehicle.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.model.entity.SessionKey;
import com.example.vehicle.dao.SessionKeyDao;
import com.example.vehicle.service.SessionKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * (SessionKey)表服务实现类
 *
 * @author makejava
 * @since 2024-05-15 15:45:04
 */
@Service("sessionKeyService")
public class SessionKeyServiceImpl extends ServiceImpl<SessionKeyDao, SessionKey> implements SessionKeyService {

    @Autowired
    SessionKeyDao sessionKeyDao;


    @Override
    public void insert(SessionKey key) {
        sessionKeyDao.insert(key);
    }

    @Override
    public SessionKey getMaxKeyIdRecord() {
        return sessionKeyDao.getMaxKeyIdRecord();
    }
}

