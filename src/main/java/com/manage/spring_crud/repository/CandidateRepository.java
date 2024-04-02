package com.manage.spring_crud.repository;

import com.manage.spring_crud.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,
        Long> {

    Candidate findByName(String name);

    List<Candidate> findByJobId(Long jobId);
}
