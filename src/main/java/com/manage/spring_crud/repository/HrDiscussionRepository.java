package com.manage.spring_crud.repository;

import com.manage.spring_crud.model.HrDiscussion;
import com.manage.spring_crud.model.InterviewFeedback1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HrDiscussionRepository extends JpaRepository<HrDiscussion, Integer> {
    HrDiscussion findByCandidateId(int candidateId);
}
