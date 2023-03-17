package com.login.user.DTO;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author fidel
 */
@Data
@Builder
public class Request {
    
     private String name;
     private String email;
     private String passwork;
}
