package com.example.biblioteca.repository;

import com.example.biblioteca.models.CopyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CopyRepository extends JpaRepository<CopyModel, Integer> {

}
