package com.example.apiuser.application.port.out;

public interface UserMessagingOutPort {
    void sendSignupEvent(Long userIdx);
}
