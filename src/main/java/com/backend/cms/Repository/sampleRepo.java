package com.backend.cms.Repository;

import com.backend.cms.Model.sampleMod;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface sampleRepo extends MongoRepository<sampleMod,String> {


}
