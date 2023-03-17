package com.login.user.controller;

import com.login.user.DTO.Request;
import com.login.user.DTO.Response;
import com.login.user.services.interfaces.IUserServices;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fidel
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private IUserServices services;
    
     @GetMapping(value ="/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> index() {
        
        return  ResponseEntity.ok(this.services.findAll());
    
    }
    
    @PostMapping(value ="/usuarios/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@Valid @RequestBody Request request){
        
        return this.services.createUser(request);
    }
    
    @PostMapping(value ="/usuarios/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Response login(@Valid @RequestBody Request request){
        
        return this.services.login(request);
    }
    
}
