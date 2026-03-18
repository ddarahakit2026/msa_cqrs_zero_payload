package com.example.apiuser.application.port.in;

import com.example.apiuser.domain.model.User;

public interface SignupUserInPort {

    record SignupCommand(String email, String password, String name) {
        public User toDomain() {
            return User.builder()
                    .email(email)
                    .password(password)
                    .name(name)
                    .build();
        }
    }

    Long signup(SignupCommand command);
}
