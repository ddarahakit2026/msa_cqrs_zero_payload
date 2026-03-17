package com.example.apiboardquery;

import lombok.Getter;

public class ReplyDto {
    @Getter
    public static class RegRes {
        private Long idx;
        private Long boardIdx;
        private String content;

        public Board.Reply toDocument() {
            return Board.Reply.builder()
                    .idx(this.idx)
                    .content(this.content)
                    .build();
        }
    }
}
