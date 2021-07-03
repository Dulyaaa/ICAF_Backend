package com.backend.cms.Controller;

import com.backend.cms.Model.Feedback;
import com.backend.cms.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "http://localhost:1234")
@RequestMapping("/feedback")
public class FeedbackController {
    @Autowired
    public FeedbackService res;

    @RequestMapping(value = "/saveFeedback", method = RequestMethod.POST)
    public Feedback test(@RequestBody Feedback feedback){
        return res.saveFeedback(feedback);
    }

}
