package com.jobrecommendation.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobDto {
    private Long id;
    private String title;
    private String location;
    private String description;
    private String skills;
    private double matchedScore; // For recommendations
}