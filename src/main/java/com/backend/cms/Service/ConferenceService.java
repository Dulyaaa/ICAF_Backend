package com.backend.cms.Service;

import com.backend.cms.Model.Conference;
import com.backend.cms.Repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConferenceService {

    public final ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceService(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    /**
     * @description Add new Conference
     * @param conference
     * @memberof ConferenceService
     */
    public void createConference(Conference conference){
        conferenceRepository.insert(conference);
    }

    /**
     * @description Get all Conferences
     * @memberof ConferenceService
     */
    public List<Conference> getAllConference(){
        return conferenceRepository.findAll();
    }

    /**
     * @description Get Important Date by id
     * @param id
     * @memberof ConferenceService
     */
    public Optional<Conference> getConferenceById(String id){
        return conferenceRepository.findById(id);
    }

    /**
     * @description Delete Conference
     * @param id
     * @memberof ConferenceService
     */
    public void deleteConference(String id) {
        conferenceRepository.deleteById(id);
    }

    /**
     * @description Get Conference By status
     * @param status
     * @memberof ConferenceService
     */
    public List<Conference> getConferenceByStatus(String status){
        return conferenceRepository.findByApproveStatus(status);
    }

    /**
     * @description Change status by Conference
     * @param id
     * @param status
     * @memberof ConferenceService
     */
    public void changeStatusByConference(String id, String status) {
        Conference conference = conferenceRepository.findByConfId(id);
        conference.setApproveStatus(status);
        conferenceRepository.save(conference);
    }
}

