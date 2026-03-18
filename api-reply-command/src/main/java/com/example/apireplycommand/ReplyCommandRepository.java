package com.example.apireplycommand;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyCommandRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByBoardIdx(Long boardIdx);

}
