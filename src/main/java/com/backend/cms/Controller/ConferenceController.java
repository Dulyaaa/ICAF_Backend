package com.backend.cms.Controller;

import com.backend.cms.Model.Conference;
import com.backend.cms.Service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:1234")
@RequestMapping("/conference")
public class ConferenceController {

    @Autowired
    private ConferenceService conferenceService;

    /**
     * @description Create new Conference
     * @param conference
     * @memberof ConferenceController
     */
    @PostMapping("/create")
    public ResponseEntity<Conference> createConference(@RequestBody Conference conference) {
        try{
            conferenceService.createConference(conference);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description Get Conference By Conference Id
     * @param id
     * @memberof ConferenceController
     */
    @GetMapping("/{id}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable("id") String id) {
        Optional<Conference> conferenceData = conferenceService.getConferenceById(id);

        if(conferenceData.isPresent()){
            return new ResponseEntity<>(conferenceData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @description Get all Conferences
     * @memberof ConferenceController
     */
    @GetMapping("/")
    public ResponseEntity<List<Conference>> getAllConference(){
        try{
            List<Conference> conference = new ArrayList<Conference>();
            conferenceService.getAllConference().forEach(conference::add);
            if(conference.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(conference, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description Delete Conference
     * @param id
     * @memberof ConferenceController
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteConference(@PathVariable String id) {
        try {
            conferenceService.deleteConference(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description Get Approved Conferences
     * @memberof ConferenceController
     */
    @GetMapping("/approvedConference")
    public ResponseEntity<List<Conference>> getApprovedConference() {
        try {
            return ResponseEntity.ok(conferenceService.getConferenceByStatus("Approved"));
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description Change Conference status
     * @param id
     * @param status
     * @memberof ConferenceController
     */
    @PutMapping("/changeStatus/{status}/{id}")
    public ResponseEntity<List<Conference>> changeStatusToApproved(@PathVariable String id, @PathVariable String status) {
        try {
            conferenceService.changeStatusByConference(id, status);
            return ResponseEntity.ok(conferenceService.getAllConference());
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

