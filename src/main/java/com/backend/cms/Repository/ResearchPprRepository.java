package com.backend.cms.Repository;

import com.backend.cms.Model.ResearchPpr;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResearchPprRepository extends MongoRepository<ResearchPpr,String> {
    public ResearchPpr save(ResearchPpr res);
}
