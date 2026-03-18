package com.example.apiuser.adapter.out.mail;

import com.example.apiuser.application.port.out.UserMailOutPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MailOutAdapter implements UserMailOutPort {
    private final JavaMailSender mailSender;

    @Override
    public String sendWelcomeMail(String email) {
        String uuid = UUID.randomUUID().toString();
        MimeMessage message  = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setTo(email);
            String subject = "[안녕] 환영";
            String htmlContents = "<a href='http://localhost:8080/user/verify?uuid="+uuid+"'>이메일 인증</a>";
            helper.setSubject(subject);
            helper.setText(htmlContents, true);
            mailSender.send(message);

            return uuid;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
