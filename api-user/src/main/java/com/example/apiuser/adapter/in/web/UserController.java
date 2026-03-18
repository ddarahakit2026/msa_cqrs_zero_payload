package com.example.apiuser.adapter.in.web;


import com.example.apiuser.adapter.in.web.request.SignupReq;
import com.example.apiuser.application.port.in.SignupUserInPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final SignupUserInPort signupUserInPort;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupReq request) {
        Long userIdx= signupUserInPort.signup(
                new SignupUserInPort.SignupCommand(request.getEmail(), request.getPassword(), request.getName())
        );

        return ResponseEntity.ok("성공");
    }
}
