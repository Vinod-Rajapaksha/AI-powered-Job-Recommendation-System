package com.jobrecommendation.service;

import com.jobrecommendation.dto.JobDto;
import com.jobrecommendation.dto.MatchedJobDto;
import com.jobrecommendation.model.Job;
import com.jobrecommendation.repository.JobRepository;
import com.jobrecommendation.util.TFIDFUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public List<JobDto> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(this::toJobDto)
                .collect(Collectors.toList());
    }

    public List<MatchedJobDto> searchAndRankJobs(String resumeText, String keywords) {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(job -> {
                    double score = TFIDFUtil.calculateMatchedScore(resumeText + " " + keywords, job.getDescription() + " " + job.getSkills());
                    return new MatchedJobDto(toJobDto(job), score);
                }).sorted((a, b) -> Double.compare(b.getMatchedScore(), a.getMatchedScore()))
                .collect(Collectors.toList());
    }

    private JobDto toJobDto(Job job) {
        return JobDto.builder()
                .id(job.getId())
                .title(job.getTitle())
                .location(job.getLocation())
                .description(job.getDescription())
                .skills(job.getSkills())
                .build();
    }

    public JobDto getJobById(Long id) {
        Job job = jobRepository.findById(id).orElseThrow();
        return toJobDto(job);
    }
}