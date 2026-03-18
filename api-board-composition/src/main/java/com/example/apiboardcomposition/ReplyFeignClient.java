package com.example.apiboardcomposition;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="replyFeignClient", url="http://localhost:8083")
public interface ReplyFeignClient {
    @GetMapping("/reply/command/list/{boardIdx}")
    public List<BoardDto.ReplyRes> getReplyList(@PathVariable Long boardIdx);
}

