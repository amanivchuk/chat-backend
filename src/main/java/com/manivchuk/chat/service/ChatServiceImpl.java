package com.manivchuk.chat.service;

import com.manivchuk.chat.model.documents.Message;
import com.manivchuk.chat.model.ChatRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Setter(onMethod_ = @Autowired)
public class ChatServiceImpl implements ChatService{

    private ChatRepository chatRepository;

    @Override
    public List<Message> findFirst10Message() {
        return chatRepository.findFirst10ByOrderByDateDesc();
    }

    @Override
    public Message save(Message message) {
        return chatRepository.save(message);
    }
}
