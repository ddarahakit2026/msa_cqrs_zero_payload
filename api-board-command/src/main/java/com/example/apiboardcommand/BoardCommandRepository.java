package com.example.apiboardcommand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardCommandRepository extends JpaRepository<Board, Long> {

}
