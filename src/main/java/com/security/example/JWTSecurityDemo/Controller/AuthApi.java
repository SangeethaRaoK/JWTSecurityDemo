package com.security.example.JWTSecurityDemo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.security.example.JWTSecurityDemo.dto.AuthRequest;
import com.security.example.JWTSecurityDemo.dto.AuthResponse;
import com.security.example.JWTSecurityDemo.entity.User;
import com.security.example.JWTSecurityDemo.security.JwtTokenUtil;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@NoArgsConstructor
@AllArgsConstructor
public class AuthApi {
	private Logger logger = LoggerFactory.getLogger(AuthApi.class);
	
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@Valid @RequestBody AuthRequest request){
		
		try {
			logger.info(request.getEmail());
			logger.info(request.getPassword());
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
		
		logger.info(request.getEmail());
		logger.info(request.getPassword());
		
		User user = (User) authentication.getPrincipal();
		
		String accessToken = jwtTokenUtil.generateAccessToken(user);
		
		AuthResponse response=new AuthResponse(user.getEmail(),accessToken);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
		catch(BadCredentialsException ex) {
			logger.info("invalid "+ex.getMessage());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}
	

}
