package com.five.group.domain.port.in;

import com.five.group.domain.model.Message;

public interface MessageProcessingUseCase {
    void processMessage(Message message);
}
