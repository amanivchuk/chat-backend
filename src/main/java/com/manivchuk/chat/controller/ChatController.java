package com.manivchuk.chat.controller;

import com.manivchuk.chat.model.documents.Message;
import com.manivchuk.chat.service.ChatService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@Setter(onMethod_ = @Autowired)
public class ChatController {

//    private String[] colors = {"red", "green", "blue", "magenta", "purple", "orange"};

    private ChatService chatService;
    private SimpMessagingTemplate webSocket;

    @MessageMapping("/message")
    @SendTo("/chat/message")
    public Message receiveMessage(Message message){
        message.setDate(new Date().getTime());

        if(message.getType().equals("NEW_USERNAME")){
//            message.setColor(colors[new Random().nextInt(colors.length)]);
            message.setColor("red");
            message.setText("new user");
        }else {
            chatService.save(message);
        }
        return message;
    }

    @MessageMapping("/writing")
    @SendTo("/chat/writing")
    public String isWriting(String username){
        return username.concat(" is writing...");
    }

    @MessageMapping("/history")
    public void history(String clientId){
        webSocket.convertAndSend("/chat/history/" + clientId, chatService.findFirst10Message());
    }


}
