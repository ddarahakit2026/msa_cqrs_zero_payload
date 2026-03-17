package com.example.apiboardcommand;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/command")
public class BoardCommandController {
    private final BoardCommandRepository repository;
    private final KafkaTemplate<Long, Long> kafkaTemplate;
    @PostMapping("/reg")
    public ResponseEntity reg(
            @RequestBody BoardDto.RegReq dto
    ) {
        Board board = repository.save(dto.toEntity());
        kafkaTemplate.send("board-created", board.getIdx(), board.getIdx());
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/{idx}")
    public ResponseEntity get(@PathVariable Long idx) {
        Board board = repository.findById(idx).orElseThrow();
        return ResponseEntity.ok(board);
    }
}
