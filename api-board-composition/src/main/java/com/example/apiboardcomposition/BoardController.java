package com.example.apiboardcomposition;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardFeignClient boardFeignClient;
    private final ReplyFeignClient replyFeignClient;

    @GetMapping("/{boardIdx}")
    public ResponseEntity get(@PathVariable Long boardIdx) {
        BoardDto.BoardRes board = boardFeignClient.getBoard(boardIdx);
        List<BoardDto.ReplyRes> replyResList = replyFeignClient.getReplyList(boardIdx);

        board.setReplies(replyResList);

        return ResponseEntity.ok(board);
    }
}
