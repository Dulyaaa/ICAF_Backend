package com.backend.cms.Service;

import com.backend.cms.Model.ImportantDate;
import com.backend.cms.Repository.ImportantDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImportantDateService {
    @Autowired
    public final ImportantDateRepository importantDateRepository;

    public ImportantDateService(ImportantDateRepository importantDateRepository) {
        this.importantDateRepository = importantDateRepository;
    }

    /**
     * @description Add new Important Dates
     * @param importantDate
     * @memberof ImportantDateService
     */
    public void addDate(ImportantDate importantDate){
        importantDateRepository.insert(importantDate);
    }

    /**
     * @description Get all Important Dates
     * @memberof ImportantDateService
     */
    public List<ImportantDate> getAllDates(){
        return importantDateRepository.findAll();
    }

    /**
     * @description Get Important Date by id
     * @param id
     * @memberof ImportantDateService
     */
    public Optional<ImportantDate> getDateById(String id){
        return importantDateRepository.findById(id);
    }

    /**
     * @description Delete Important Dates
     * @param id
     * @memberof ImportantDateService
     */
    public void deleteDate(String id) {
        importantDateRepository.deleteById(id);
    }
}
