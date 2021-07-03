package com.backend.cms.Controller;

import com.backend.cms.Model.Workshop;
import com.backend.cms.Service.WorkshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/workshop")

public class workshopDController {
    @Autowired
    private WorkshopService workshopService;

    // Get All workshops
    @GetMapping("/")
    public List<Workshop> getAllWorkshops() {
        return workshopService.getAll();
    }

    // Get Workshop By User Id
    @GetMapping("/byUserId/{id}")
    public List<Workshop> getWorkshopByUserId(@PathVariable("id") String id) {
        return workshopService.findByUserId(id);
    }

    // Get Workshop By Id
    @GetMapping("/byId/{id}")
    public Workshop getById(@PathVariable("id") String id) {
        
        return workshopService.getById(id);
    }

    // Store New Workshop
    @PostMapping("/create")
    public Workshop saveWorkshop(@RequestBody Workshop workshop) {
        return workshopService.saveOrUpdateWorkshop(workshop);
    }

    // Update Workshop
    @PutMapping("/update")
    public Workshop updateWorkshop(@RequestBody Workshop workshop) {
        return workshopService.saveOrUpdateWorkshop(workshop);
    }

    // Delete Workshop By Id
    @DeleteMapping("/{id}")
    public void deleteWorkshop(@PathVariable("id") String id) {
        workshopService.deleteWorkshopById(id);
    }



}
