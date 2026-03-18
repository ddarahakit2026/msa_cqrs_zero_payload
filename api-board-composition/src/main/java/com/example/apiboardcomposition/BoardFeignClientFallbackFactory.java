package com.example.apiboardcomposition;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class BoardFeignClientFallbackFactory implements FallbackFactory<BoardFeignClient> {

    @Override
    public BoardFeignClient create(Throwable cause) {
        return new BoardFeignClientFallback(cause);
    }
}