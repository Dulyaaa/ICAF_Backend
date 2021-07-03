package com.backend.cms.Repository;

import com.backend.cms.Model.Keynote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeynoteRepository extends MongoRepository<Keynote,String> {
}
