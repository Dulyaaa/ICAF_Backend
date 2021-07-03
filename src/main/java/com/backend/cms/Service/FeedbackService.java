package com.backend.cms.Service;

import com.backend.cms.Model.Feedback;
import com.backend.cms.Model.ResearchPpr;
import com.backend.cms.Repository.FeedbackRepo;
import com.backend.cms.Repository.ResearchPprRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FeedbackService {
    @Autowired
    public FeedbackRepo feed;

    public Feedback saveFeedback(Feedback feedback) {
        return  feed.save(feedback);
    }
}
