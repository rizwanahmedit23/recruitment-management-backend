package com.manage.spring_crud.services;

import com.manage.spring_crud.model.Candidate;
import com.manage.spring_crud.model.ResourceRequirements;
import com.manage.spring_crud.repository.CandidateRepository;
import com.manage.spring_crud.repository.ResourceRequirementsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ResourceRequirementsRepository resourceRequirementsRepository;

    public Candidate addCandidate(Candidate candidate, Integer resourceRequirementsId) {
        ResourceRequirements resourceRequirements = resourceRequirementsRepository.findById(resourceRequirementsId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));

//        candidate.setResourceRequirements(resourceRequirements);
        return candidateRepository.save(candidate);
    }

    public List<Candidate> addAllCandidates(List<Candidate> candidates) {
        return candidateRepository.saveAll(candidates);
    }

    public Candidate getCandidateByID(
            Long id) {
        return candidateRepository.findById(id).orElse(null);

    }


    public Candidate getCandidateByName(String name) {
        return candidateRepository.findByName(name);
    }

    public Candidate updateCandidate(Candidate candidate) {
        Candidate exitingCand = candidateRepository.findById(candidate.getId()).orElse(null);

        if (exitingCand == null) {
            return candidateRepository.save(candidate);
        } else {
            candidateRepository.deleteById(exitingCand.getId());
            candidateRepository.save(candidate);
        }
        return candidate;
    }

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public List<Candidate> getAllCandidatesByJobId(Long jobId) {
        // Assuming you have a method to retrieve candidates by job id in your repository
        return candidateRepository.findByJobId(jobId);
    }
}
