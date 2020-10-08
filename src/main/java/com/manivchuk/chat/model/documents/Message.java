package com.manivchuk.chat.model.documents;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "messages")
public class Message implements Serializable {

    @Id
    private String id;

    private String text;

    private Long date;
    
    private String username;

    private String type;

    private String color;

    private static final long serialVersionUID = -3777582564067492550L;

}
