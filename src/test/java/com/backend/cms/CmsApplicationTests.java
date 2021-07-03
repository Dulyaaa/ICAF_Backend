package com.backend.cms;

import com.backend.cms.Model.Conference;
import com.backend.cms.Repository.ConferenceRepository;
import org.junit.jupiter.api.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@DataMongoTest
class CmsApplicationTests {

    @Autowired
    private ConferenceRepository conferenceRepository;

    @Test
    public void testGetConferenceAll() {
        List<Conference> conference = conferenceRepository.findAll();
        assertThat(conference.size(), is(greaterThanOrEqualTo(1)));
    }

    @Test
    public void testGetApprovedConference() {
        List<Conference> conference = conferenceRepository.findByApproveStatus("Pending");
        assertThat(conference.size(), is(greaterThanOrEqualTo(1)));
    }

}