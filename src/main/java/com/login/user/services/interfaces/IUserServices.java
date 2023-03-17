
package com.login.user.services.interfaces;

import com.login.user.DTO.Request;
import com.login.user.DTO.Response;
import com.login.user.entity.TblUsuarios;
import java.util.List;

/**
 *
 * @author fidel
 */
public interface IUserServices {
    
    List<TblUsuarios> findAll();
    
    Response createUser(Request r);
    
    Response login(Request r);
}
