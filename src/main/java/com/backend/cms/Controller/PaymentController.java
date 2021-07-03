package com.backend.cms.Controller;
import com.backend.cms.Model.Payment;
import com.backend.cms.Repository.PaymentRepo;

import com.backend.cms.Service.sampleServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/payments")

public class PaymentController {

    @Autowired
    public PaymentRepo ipayment;

    @Autowired
    public sampleServ sampleServ;


    @RequestMapping(value = "/addPayment", method = RequestMethod.POST)
    public Payment savePayment(@RequestBody Payment payment){
        return sampleServ.savePayment(payment);
    }
}
