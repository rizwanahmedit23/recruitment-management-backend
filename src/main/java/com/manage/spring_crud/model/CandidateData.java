package com.manage.spring_crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateData {
    private Long id;

    private String name;

    private String email;

    private String mobile;

    private int experience;

    private int resourceRequirementID;

}
