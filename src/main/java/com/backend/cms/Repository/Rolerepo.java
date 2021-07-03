package com.backend.cms.Repository;

import com.backend.cms.Model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Rolerepo  extends MongoRepository<Role,String> {


}
