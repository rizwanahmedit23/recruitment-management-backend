package com.manage.spring_crud.controller;

import com.manage.spring_crud.model.Candidate;
import com.manage.spring_crud.model.CandidateData;
import com.manage.spring_crud.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    //Add new Candidate
    @PostMapping("/addCandidate/{jobId}")
    public Candidate addCandidate(@PathVariable int jobId, @RequestBody CandidateData candidateData) {
        System.out.println("candidate controller add candidates "+ candidateData);

        Candidate candidate = new Candidate();
        candidate.setJobId(jobId);
        candidate.setName(candidateData.getName());
        candidate.setName(candidateData.getName());
        candidate.setEmail(candidateData.getEmail());
        candidate.setMobile(candidateData.getMobile());
        return candidateService.addCandidate(candidate, candidateData.getResourceRequirementID());
    }

    // Add more than 1 candidate
    @PostMapping("/addCandidates")
    public List<Candidate> addAllCandidates(@RequestBody List<Candidate> candidates) {
        return candidateService.addAllCandidates(candidates);
    }
//    @GetMapping("/abc")
//    public String getCandidabc() {
//        return "called";
//    }
    @GetMapping("/abc")
    public ResponseEntity<String> getCandidate() {
        return new ResponseEntity<>("{\"message\": \"called\"}", HttpStatus.OK);
    }

    //Get Candidate by Id
    @GetMapping("/getEmployeeByID/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateByID(id);
    }

    //Get Candidate by Name
    @GetMapping("/getCandidateByName/{name}")
    public Candidate getCandidateByName(@PathVariable String name) {
        return candidateService.getCandidateByName(name);
    }

    // Update Candidate
    @PutMapping("/updateCandidate")
    public Candidate updateCandidate(@RequestBody Candidate candidate) {
        return candidateService.updateCandidate(candidate);
    }


    // Get all Candidates
    @GetMapping("/getCandidates")
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();

    }

    @GetMapping("/getAllCandidatesByJobId/{jobId}")
    public List<Candidate> getAllCandidatesByJobId(@PathVariable Long jobId) {
        return candidateService.getAllCandidatesByJobId(jobId);
    }

}
