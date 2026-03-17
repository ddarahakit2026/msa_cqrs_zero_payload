package com.example.apireplycommand;

import lombok.Getter;

public class ReplyDto {
    @Getter
    public static class RegReq {
        private Long boardIdx;
        private String content;

        public Reply toEntity() {
            return Reply.builder()
                    .boardIdx(this.boardIdx)
                    .content(this.content)
                    .build();
        }
    }
}
