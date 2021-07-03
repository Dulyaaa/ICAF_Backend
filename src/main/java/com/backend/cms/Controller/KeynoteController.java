package com.backend.cms.Controller;

import com.backend.cms.Model.Keynote;
import com.backend.cms.Service.KeynoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/keynote")
public class KeynoteController {

    private KeynoteService keynoteService;

    /**
     * @description Get all Keynote
     * @memberof KeynoteController
     */
    @GetMapping("/")
    public ResponseEntity<List<Keynote>> getAllKeynote(){
        try{
            List<Keynote> keynotes = new ArrayList<Keynote>();
            keynoteService.getAllKeynotes().forEach(keynotes::add);
            if(keynotes.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(keynotes, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
