package com.example.apiboardcomposition;

import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class BoardFeignClientFallback implements BoardFeignClient {

    private final Throwable cause;

    @Override
    public BoardDto.BoardRes getBoard(Long idx) {
        System.out.println("게시글 가져오다가 에러 발생: " + cause.getMessage());
        return BoardDto.BoardRes.builder()
                .title("에러남")
                .replies(new ArrayList<BoardDto.ReplyRes>())
                .build();
    }
}