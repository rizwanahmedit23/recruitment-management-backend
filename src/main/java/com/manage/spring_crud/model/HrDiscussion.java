package com.manage.spring_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HrDiscussion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int hrDiscussionId;
    private String communicationSkills;
    private String culturalFit;
    private String finalDecision;

    private int candidateId;

//    @OneToOne
//    private Candidate candidate;
}
