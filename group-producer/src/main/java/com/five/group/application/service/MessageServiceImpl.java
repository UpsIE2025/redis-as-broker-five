package com.five.group.application.service;

import com.five.group.application.port.in.MessageUseCase;
import com.five.group.application.port.out.MessagePublisher;
import com.five.group.domain.model.Message;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageUseCase {
    private final MessagePublisher messagePublisher;

    @Override
    public void SendMessage(String content) {
        Message message = new Message(content);
        messagePublisher.publish(message);
    }
}
