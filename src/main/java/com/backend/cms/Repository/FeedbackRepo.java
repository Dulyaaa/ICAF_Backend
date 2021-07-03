package com.backend.cms.Repository;

import com.backend.cms.Model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepo extends MongoRepository<Feedback,String> {
    public Feedback save(Feedback res);
}
