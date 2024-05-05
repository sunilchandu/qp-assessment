package com.groceryCart.controller;

import com.groceryCart.Dto.*;
import com.groceryCart.entity.*;
import com.groceryCart.service.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
	@Autowired
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
        String token = authService.login(loginDto);

        JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) throws Exception{
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
   
 // Build Update Category REST API
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = {"/getallusers"})
    public ResponseEntity<List<User>> getallUSers() throws Exception{
    	List<User> allusers= authService.getallusers(); 
        return ResponseEntity.ok(allusers);
    }
    

    
    // Build Register REST API
    @PostMapping(value = {"/addrole"})
    public ResponseEntity<String> addRole(@RequestBody Role role) throws Exception{
        String response = authService.addRole(role);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    
    
}