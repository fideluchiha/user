/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.login.user.services.implementation;

import com.login.user.DTO.Request;
import com.login.user.DTO.Response;
import com.login.user.Util.Util;
import com.login.user.entity.TblUsuarios;
import com.login.user.repository.UserRepository;
import com.login.user.services.interfaces.IUserServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author fidel
 */

@Component
public class UserImplements implements IUserServices{
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
    private Util util;
    @Override
    public List<TblUsuarios> findAll() {
       
        return (List<TblUsuarios>) repository.findAll();
   }

    @Override
    public Response createUser(Request request) {
        try{
      TblUsuarios user = repository.save(
                TblUsuarios.builder().
                    name(request.getName()).
                    email(request.getEmail()).
                    passwork(util.hashEncritp(request.getPasswork())).
                            build());
       
       if(user.getIdUsuario()!=0){
           
           return Response.builder().
                   codigoRespuesta("0").
                   mensaje("Proceso exitoso!!!").build();
       }else{
           return Response.builder().
                   codigoRespuesta("1").
                   mensaje("Error!!!").build();
       }
        }catch(Exception e){
            
             return Response.builder().
                   codigoRespuesta("1").
                   mensaje("Error verifique si el correo ya existe!!!").build();
        }
    }

    @Override
    public Response login(Request request) {
        
        Optional<TblUsuarios> user = 
                repository.
                        findByEmailAndPasswork(request.getEmail(),
                                util.hashEncritp(request.getPasswork()));
        
        if(user.isPresent()){
            return Response.builder().
                   codigoRespuesta("0").
                   mensaje("Proceso exitoso!!!").
                    name(user.get().getName()).build();
            }
        else{
            
            return Response.builder().
                   codigoRespuesta("1").
                   mensaje("Usuario o clave erronea!!!").build();}
    }
    
}
