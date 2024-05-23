package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.model.entity.Card;
import com.example.user.dao.CardDao;
import com.example.user.service.CardService;
import org.springframework.stereotype.Service;

/**
 * (Card)表服务实现类
 *
 * @author makejava
 * @since 2024-05-15 10:08:09
 */
@Service("cardService")
public class CardServiceImpl extends ServiceImpl<CardDao, Card> implements CardService {

}

