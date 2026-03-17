package com.example.apireplycommand;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/reply/command")
public class ReplyCommandController {
    private final ReplyCommandRepository repository;
    private final KafkaTemplate<Long, Long> kafkaTemplate;
    @PostMapping("/reg")
    public ResponseEntity reg(
            @RequestBody ReplyDto.RegReq dto
    ) {
        Reply reply = repository.save(dto.toEntity());
        kafkaTemplate.send("reply-created", reply.getIdx(), reply.getIdx());
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/{idx}")
    public ResponseEntity get(@PathVariable Long idx) {
        Reply reply = repository.findById(idx).orElseThrow();
        return ResponseEntity.ok(reply);
    }
}
