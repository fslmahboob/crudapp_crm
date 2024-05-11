package com.fdm.soloproject2.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("auth/login")
    public String token(Authentication authentication) {
    	System.out.println("Login Attempted");
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted: {}", token);
        return token;
    }
    
    @GetMapping("example")
    public String example(Authentication auth) {
    	System.out.println("name:  " +auth.getName());
    	System.out.println("princ: " + auth.getPrincipal());
    	System.out.println("creds: " + auth.getCredentials());
    	System.out.println(auth.getAuthorities());
    	return "Hello, " + auth.getName();
    }
    
    @GetMapping("adminonly")
    public String example() {
    	return "You must be an admin";
    }
    
}
