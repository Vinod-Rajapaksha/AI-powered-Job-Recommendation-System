package com.jobrecommendation.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeUploadDto {
    private String filename;
    private String fileContentBase64;
}