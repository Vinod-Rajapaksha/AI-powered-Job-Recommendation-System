package com.jobrecommendation.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDto {
    private String username;
    private String password;
}