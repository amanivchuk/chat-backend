package com.manivchuk.chat.model;

import com.manivchuk.chat.model.documents.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChatRepository extends MongoRepository<Message, String> {

    List<Message> findFirst10ByOrderByDateDesc();
}
