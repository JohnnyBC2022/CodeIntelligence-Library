package com.example.biblioteca.repository;

import com.example.biblioteca.models.MemberModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<MemberModel, Integer> {

}
