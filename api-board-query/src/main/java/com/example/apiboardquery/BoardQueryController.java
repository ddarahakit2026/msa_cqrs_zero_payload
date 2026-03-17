package com.example.apiboardquery;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board/query")
public class BoardQueryController {
    private final BoardFeignClient boardFeignClient;
    private final ReplyFeignClient replyFeignClient;
    private final BoardRepository boardRepository;
    @KafkaListener(topics="board-created", groupId = "board-query-group-01")
    public void boardCreatedHandler(@Header(KafkaHeaders.RECEIVED_KEY) Long key,
                        @Payload Long boardIdx) {
        BoardDto.RegRes result = boardFeignClient.getBoard(boardIdx);
        System.out.println(result.getTitle());
        boardRepository.save(result.toDocument());
    }

    @KafkaListener(topics="reply-created", groupId = "board-query-group-01")
    public void replyCreatedHandler(@Header(KafkaHeaders.RECEIVED_KEY) Long key,
                        @Payload Long replyIdx) {
        ReplyDto.RegRes result = replyFeignClient.getReply(replyIdx);
        Board board = boardRepository.findById(result.getBoardIdx()).orElseThrow();

        board.getReplies().add(result.toDocument());
        boardRepository.save(board);
    }


    @GetMapping("/list")
    public List<Board> findAll() {
        List<Board> list = new ArrayList<>();
        boardRepository.findAll().forEach(list::add);
        return list;
    }

    @GetMapping("/{idx}")
    public Board findById(@PathVariable Long idx) {
        return boardRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("Board not found"));
    }
}
