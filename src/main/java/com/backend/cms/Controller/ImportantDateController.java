package com.backend.cms.Controller;

import com.backend.cms.Model.ImportantDate;
import com.backend.cms.Service.ImportantDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/importantDate")
public class ImportantDateController {

    @Autowired
    private ImportantDateService importantDateService;

    /**
     * @description Create new Important Dates
     * @param importantDate
     * @memberof ImportantDateController
     */
    @PostMapping("/create")
    public ResponseEntity createImportantDate(@RequestBody ImportantDate importantDate){
        try {
            importantDateService.addDate(importantDate);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description Get all Important Dates
     * @memberof ImportantDateController
     */
    @GetMapping("/")
    public ResponseEntity<List<ImportantDate>> getAllImportantDates(){
        try{
            List<ImportantDate> important_date = new ArrayList<ImportantDate>();
            importantDateService.getAllDates().forEach(important_date::add);
            if(important_date.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(important_date, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * @description Get Important Date by Id
     * @param id
     * @memberof ImportantDateController
     */
    @GetMapping("/{id}")
    public Object getImportantDateById(@PathVariable String id){
        Optional<ImportantDate> date_data = importantDateService.getDateById(id);
        if(date_data.isPresent()){
            return new ResponseEntity<>(date_data.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * @description Delete Important Dates
     * @param id
     * @memberof ImportantDateController
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteConference(@PathVariable String id) {
        importantDateService.deleteDate(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
