package com.manage.spring_crud.repository;

import com.manage.spring_crud.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,
        Long> {

    Candidate findByName(String name);
}
