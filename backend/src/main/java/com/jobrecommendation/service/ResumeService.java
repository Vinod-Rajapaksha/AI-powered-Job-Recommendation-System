package com.jobrecommendation.service;

import com.jobrecommendation.model.UserResume;
import com.jobrecommendation.repository.UserResumeRepository;
import com.jobrecommendation.util.PDFParserUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final UserResumeRepository userResumeRepository;

    public UserResume uploadAndParseResume(Long userId, byte[] pdfBytes) {
        String text = PDFParserUtil.extractText(pdfBytes);
        UserResume resume = UserResume.builder()
                .userId(userId)
                .resumeText(text)
                .build();
        return userResumeRepository.save(resume);
    }
}