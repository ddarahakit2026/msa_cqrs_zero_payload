package com.example.apiuser.domain.model;

import com.example.apiuser.application.port.in.SignupUserInPort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class User {
    private Long idx;
    private String email;
    private String password;
    private String name;
}
