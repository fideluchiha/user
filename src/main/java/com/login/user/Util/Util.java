/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.user.Util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import org.springframework.stereotype.Component;

/**
 *
 * @author fidel
 */
@Component
public class Util {
    
     public String hashEncritp(String passwork){
        
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(passwork.getBytes(StandardCharsets.UTF_8));
            String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
            
            // imprimir resumen de mensaje SHA-256
            System.out.println(sha256);
            
            
            return sha256;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
