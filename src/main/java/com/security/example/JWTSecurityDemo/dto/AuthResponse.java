package com.security.example.JWTSecurityDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {
	private String email;
    private String accessToken;
 
    public AuthResponse() { }
     
    public AuthResponse(String email, String accessToken) {
        this.email = email;
        this.accessToken = accessToken;
    }

}
