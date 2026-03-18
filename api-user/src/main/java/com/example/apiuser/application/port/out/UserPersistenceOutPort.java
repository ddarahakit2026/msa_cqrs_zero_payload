package com.example.apiuser.application.port.out;

import com.example.apiuser.domain.model.User;

public interface UserPersistenceOutPort {
    User signup(User user);
}
