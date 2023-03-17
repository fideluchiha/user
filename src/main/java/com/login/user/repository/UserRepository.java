
package com.login.user.repository;

import com.login.user.entity.TblUsuarios;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author fidel
 */
@Repository
public interface UserRepository extends CrudRepository<TblUsuarios, Long>{
    
    Optional<TblUsuarios> findByEmailAndPasswork(String email, String passwork);
    
}
