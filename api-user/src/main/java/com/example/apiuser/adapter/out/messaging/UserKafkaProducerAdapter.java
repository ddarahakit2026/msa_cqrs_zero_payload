package com.example.apiuser.adapter.out.messaging;

import com.example.apiuser.application.port.out.UserMessagingOutPort;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserKafkaProducerAdapter implements UserMessagingOutPort {
    private final KafkaTemplate<Long, Long> kafkaTemplate;


    @Override
    public void sendSignupEvent(Long userIdx) {
        kafkaTemplate.send("user-signup", userIdx, userIdx);
    }
}
