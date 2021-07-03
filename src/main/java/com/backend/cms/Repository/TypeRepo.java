package com.backend.cms.Repository;

import com.backend.cms.Model.Role;
import com.backend.cms.Model.RoleType;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TypeRepo extends MongoRepository<RoleType,String> {

}
