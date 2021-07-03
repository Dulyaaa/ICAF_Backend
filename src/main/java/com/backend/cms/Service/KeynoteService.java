package com.backend.cms.Service;

import com.backend.cms.Model.Keynote;
import com.backend.cms.Repository.KeynoteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class KeynoteService {
    @Autowired
    public final KeynoteRepository keynoteRepository;

    public KeynoteService(KeynoteRepository keynoteRepository) {
        this.keynoteRepository = keynoteRepository;
    }

    /**
     * @description Get all Keynotes
     * @memberof KeynoteService
     */
    public List<Keynote> getAllKeynotes(){
        return keynoteRepository.findAll();
    }
}
