package com.five.group.application;

import com.five.group.domain.model.Message;
import com.five.group.domain.port.in.MessageProcessingUseCase;

import lombok.extern.log4j.Log4j2;

import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MessageProcessingServiceImpl implements MessageProcessingUseCase {
    @Override
    public void processMessage(Message message) {
        log.info("Procesando mensaje: {}", message.getContent());
    }
}
