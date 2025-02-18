package com.five.group.application.service;

import com.five.group.domain.port.in.SendMessage;
import com.five.group.domain.port.out.EmitMessage;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class SendMessageImpl implements SendMessage {

    private final EmitMessage emitMessage;

    @Override
    public void send(String message) {
        emitMessage.emit(message);
    }
}
