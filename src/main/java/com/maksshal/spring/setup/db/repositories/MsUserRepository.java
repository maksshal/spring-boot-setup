package com.maksshal.spring.setup.db.repositories;

import com.maksshal.spring.setup.db.entities.MsUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MsUserRepository extends CrudRepository<MsUser, Long> {
    
    MsUser findByLastName(@Param("lastName") String name);
}
