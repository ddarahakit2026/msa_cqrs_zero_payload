package com.example.apiuser.adapter.out.persistence;

import com.example.apiuser.application.port.out.UserPersistenceOutPort;
import com.example.apiuser.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistenceOutPort {
    private final UserJpaRepository userJpaRepository;

    @Override
    public User signup(User domain) {
        UserEntity userEntity = UserEntity.from(domain);
        userEntity = userJpaRepository.save(userEntity);
        return userEntity.toDomain();
    }
}
