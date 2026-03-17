package com.example.apiboardquery;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="replyFeignClient", url="http://localhost:8083")
public interface ReplyFeignClient {
    @GetMapping("/reply/command/{idx}")
    public ReplyDto.RegRes getReply(@PathVariable Long idx);
}
