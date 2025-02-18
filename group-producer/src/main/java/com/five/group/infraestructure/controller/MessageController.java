package com.five.group.infraestructure.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.five.group.domain.port.in.SendMessage;
import com.five.group.infraestructure.dtos.MessageContent;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final SendMessage sendMessage;

    @PostMapping
    public ResponseEntity<String> postMessage(@RequestBody @Valid MessageContent content) {
        sendMessage.send(content.getContent());

        return ResponseEntity.ok("Message sent to Redis");
    }
}
