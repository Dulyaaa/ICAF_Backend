package com.backend.cms.Repository;

import com.backend.cms.Model.Workshop;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WorkshopRepo extends MongoRepository<Workshop,String> {
    List<Workshop> findByUserId(String userId);
}
