package com.manage.spring_crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String mobile;

    private int experience;

//    @Lob
//    @Column(columnDefinition = "MEDIUMBLOB")
//    private byte[] resumeContent;
//
//    @Column
//    private String fileExtension;

    @OneToOne(mappedBy = "candidate")
    private InterviewFeedback1 interviewFeedback1;

    @OneToOne(mappedBy = "candidate")
    private InterviewFeedback2 interviewFeedback2;

    @OneToOne(mappedBy = "candidate")
    private HrDiscussion hrDiscussion;

//    @ManyToOne
//    @JoinColumn(name = "resource_requirements_id")
//    @JsonManagedReference
//    private ResourceRequirements resourceRequirements;

    @OneToOne(mappedBy = "candidate")
    private DiscussionDetails discussionDetails;
}
