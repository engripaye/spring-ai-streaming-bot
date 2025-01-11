package com.ipaye.springaistreamingbot;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ChatController {
    private final ChatClient chatClient;


    public ChatController(ChatClient.Builder builder) {
        this.chatClient= builder
                .build();
    }

    @PostMapping("/chat")
    public String Chat (@RequestParam String message){
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}
