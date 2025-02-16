package com.five.group.infraestructure.controller;

import com.five.group.application.port.in.MessageUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageUseCase messageUseCase;

    public MessageController(MessageUseCase messageUseCase) {
        this.messageUseCase = messageUseCase;
    }

    @PostMapping
    public ResponseEntity<String> postMessage(@RequestBody String content) {
        messageUseCase.SendMessage(content);
        return ResponseEntity.ok("Message sent to Redis");
    }
}
