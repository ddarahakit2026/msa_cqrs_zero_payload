package com.example.apiboardquery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@Document(indexName = "board")
public class Board {
    @Id
    private Long idx;

    @Field(type = FieldType.Text, analyzer = "nori")
    private String title;

    @Field(type = FieldType.Text, analyzer = "nori")
    private String content;

    @Builder.Default
    private List<Reply> replies = new ArrayList<>();

    @Getter
    @Builder
    public static class Reply {
        private Long idx;
        @Field(type = FieldType.Text, analyzer = "nori")
        private String content;
    }

}
