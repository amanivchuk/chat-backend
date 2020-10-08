package com.manivchuk.chat.service;

import com.manivchuk.chat.model.documents.Message;

import java.util.List;

public interface ChatService {

    List<Message> findFirst10Message();

    Message save(Message message);
}
