package com.npk.jwt.payload.response;

import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";

    public JwtAuthenticationResponse(String jwt) {
        accessToken = jwt;
    }
}
