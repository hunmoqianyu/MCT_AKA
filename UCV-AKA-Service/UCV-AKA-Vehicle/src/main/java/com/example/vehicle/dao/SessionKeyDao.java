package com.example.vehicle.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.entity.SessionKey;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SessionKey)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-15 15:45:04
 */
@Mapper
public interface SessionKeyDao extends BaseMapper<SessionKey> {

    int insert(SessionKey key);

    SessionKey getMaxKeyIdRecord();
}

