package com.example.apiuser.adapter.out.persistence;

import com.example.apiuser.domain.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String email;
    private String password;
    private String name;

    public static UserEntity from(User domain) {
        return UserEntity.builder()
                .email(domain.getEmail())
                .password(domain.getPassword())
                .name(domain.getName())
                .build();
    }

    public User toDomain() {
        return User.builder()
                .idx(this.idx)
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .build();
    }


}
