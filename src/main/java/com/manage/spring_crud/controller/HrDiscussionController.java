package com.manage.spring_crud.controller;

import com.manage.spring_crud.model.HrDiscussion;
import com.manage.spring_crud.model.InterviewFeedback2;
import com.manage.spring_crud.services.HrDiscussionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hrDiscussion")

public class HrDiscussionController {
    @Autowired
    private HrDiscussionService hrDiscussionService;

    //Add new Hr Discussion Feedback
//    @PostMapping("/addHrDiscussion")
//    public HrDiscussion addHrDiscussion(@RequestBody HrDiscussion hrDiscussion) {
//        System.out.println("Add called");
//        return hrDiscussionService.addHrDiscussion(hrDiscussion);
//    }
//
//    // Add more than 1 Hr Discussion Feedback
//    @PostMapping("/addHrDiscussions")
//    public List<HrDiscussion> addAllHrDiscussion(@RequestBody List<HrDiscussion> hrDiscussions) {
//        return hrDiscussionService.addAllHrDiscussion(hrDiscussions);
//    }

    @PostMapping("/addHrDiscussionByCandidateID/{id}")
    public HrDiscussion addHrDiscussionByCandidateId(@PathVariable int candidateId, @RequestBody HrDiscussion hrDiscussion) {
        // Set the candidate id for the interview feedback
        hrDiscussion.setCandidateId(candidateId);
        // Save the interview feedback
        return hrDiscussionService.addHrDiscussion(hrDiscussion);
    }

    //Get Hr Discussion details by Id
    @GetMapping("/getHrDiscussionByID/{id}")
    public HrDiscussion getHrDiscussionById(@PathVariable int id) {
        return hrDiscussionService.getHrDiscussionByID(id);
    }

    @GetMapping("/getHrDiscussionByCandidateID/{id}")
    public HrDiscussion getHrDiscussionByCandidateId(@PathVariable int id) {
        return hrDiscussionService.getHrDiscussionByCandidateID(id);
    }

    // Update Hr Discussion
    @PutMapping("/updateHrDiscussion")
    public HrDiscussion updateHrDiscussion(@RequestBody HrDiscussion hrDiscussion) {
        return hrDiscussionService.updateHrDiscussion(hrDiscussion);
    }

    @GetMapping("/getHrDiscussions")
    public List<HrDiscussion> getAllHrDiscussions() {
        return hrDiscussionService.getAllHrDiscussions();
    }
}
