package com.example.apiboardcomposition;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="boardFeignClient", url="http://localhost:8081")
public interface BoardFeignClient {
    @GetMapping("/board/command/{idx}")
    public BoardDto.BoardRes getBoard(@PathVariable Long idx);
}
