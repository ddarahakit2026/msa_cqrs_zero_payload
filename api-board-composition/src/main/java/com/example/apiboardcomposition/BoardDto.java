package com.example.apiboardcomposition;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BoardDto {
    @Getter
    @Builder
    public static class BoardRes {
        private Long idx;
        private String title;
        private String content;
        @Setter
        private List<ReplyRes> replies;
    }
    @Getter
    public static class ReplyRes {
        private Long idx;
        private String content;
    }

}
