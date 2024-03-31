package com.manage.spring_crud.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResourceRequirements {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int requirementId;

    private String title;

    @Column(length = 100000)
    private String description;

    @Column(length = 100000)
    private String responsibilities;

    @Column(length = 100000)
    private String requirements;

    private String experience;

    private String shiftTiming;

    private String status;

    @OneToMany(
//            mappedBy = "resourceRequirements",
            cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//    @JsonBackReference
    private List<Candidate> candidates;
}

