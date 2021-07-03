package com.backend.cms.Controller;


import com.backend.cms.Model.sampleMod;
import com.backend.cms.Service.sampleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleCon {

    @Autowired
    public sampleServ peru;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public boolean test(@RequestBody sampleMod sam){
        return peru.testMethod(sam);
    }

}
