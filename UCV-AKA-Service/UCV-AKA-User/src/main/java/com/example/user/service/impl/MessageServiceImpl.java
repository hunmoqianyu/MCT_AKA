package com.example.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.example.model.entity.Message;
import com.example.user.service.MessageService;
import org.springframework.stereotype.Service;
import com.example.user.dao.MessageDao;

/**
 * (Message)表服务实现类
 *
 * @author makejava
 * @since 2024-05-16 16:12:38
 */
@Service("messageService")
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {

}

