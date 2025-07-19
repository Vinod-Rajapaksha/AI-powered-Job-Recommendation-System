package com.jobrecommendation.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MatchedJobDto {
    private JobDto job;
    private double matchedScore;
}