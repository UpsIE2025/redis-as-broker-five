package com.five.group.application;

import com.five.group.domain.model.Message;
import com.five.group.domain.port.in.MessageProcessingUseCase;
import org.springframework.stereotype.Service;

@Service
public class MessageProcessingServiceImpl implements MessageProcessingUseCase {
    @Override
    public void processMessage(Message message) {
        System.out.println("Procesando mensaje: " + message.getContent());
    }
}
