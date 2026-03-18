package com.example.apiuser.application.usecase;

import com.example.apiuser.application.port.in.SignupUserInPort;
import com.example.apiuser.application.port.out.UserPersistenceOutPort;
import com.example.apiuser.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserUseCase implements SignupUserInPort {
    private final UserPersistenceOutPort userPersistenceOutPort;

    @Override
    public Long signup(SignupCommand command) {
        User user = command.toDomain();
        user = userPersistenceOutPort.signup(user);
        return user.getIdx();
    }
}
