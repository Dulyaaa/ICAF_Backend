package com.backend.cms.Repository;

import com.backend.cms.Model.Conference;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepository extends MongoRepository<Conference,String> {
    List<Conference> findByApproveStatus(String approveStatus);
    Conference findByConfId(String confId);
}
