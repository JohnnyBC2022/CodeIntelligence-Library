package com.example.biblioteca.repository;

import com.example.biblioteca.models.Token;
import com.example.biblioteca.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Integer> {
    @Query("SELECT t FROM Token t WHERE t.user.id = :userId")
    List<Token> findAllTokensByUser(@Param("userId") int userId);

    Optional<Token> findByToken(String token);
}
