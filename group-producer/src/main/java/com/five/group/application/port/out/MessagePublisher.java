package com.five.group.application.port.out;

import com.five.group.domain.model.Message;

public interface MessagePublisher{
    void publish(Message message);
}
