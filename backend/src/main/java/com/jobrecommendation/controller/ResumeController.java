package com.jobrecommendation.controller;

import com.jobrecommendation.model.UserResume;
import com.jobrecommendation.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/upload")
    public UserResume uploadResume(@RequestParam Long userId, @RequestParam("file") MultipartFile file) throws Exception {
        byte[] pdfBytes = file.getBytes();
        return resumeService.uploadAndParseResume(userId, pdfBytes);
    }
}