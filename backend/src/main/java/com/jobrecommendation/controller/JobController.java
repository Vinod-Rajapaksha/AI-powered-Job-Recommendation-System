package com.jobrecommendation.controller;

import com.jobrecommendation.dto.JobDto;
import com.jobrecommendation.dto.MatchedJobDto;
import com.jobrecommendation.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public List<JobDto> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public JobDto getJob(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PostMapping("/search")
    public List<MatchedJobDto> searchJobs(@RequestParam(required = false) String resumeText,
                                          @RequestParam(required = false) String keywords) {
        return jobService.searchAndRankJobs(resumeText == null ? "" : resumeText, keywords == null ? "" : keywords);
    }
}