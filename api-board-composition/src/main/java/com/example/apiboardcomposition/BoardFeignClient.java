package com.example.apiboardcomposition;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="boardFeignClient", url="http://localhost:8081", fallbackFactory = BoardFeignClientFallbackFactory.class)
public interface BoardFeignClient {

    @GetMapping("/board/command/{idx}")
    public BoardDto.BoardRes getBoard(@PathVariable Long idx);

}
