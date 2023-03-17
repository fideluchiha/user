/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.user.DTO;

import lombok.Builder;
import lombok.Data;

/**
 *
 * @author fidel
 */

@Data
@Builder
public class Response {
    
    private String codigoRespuesta;
    private String mensaje;
    private String name;
    
}
