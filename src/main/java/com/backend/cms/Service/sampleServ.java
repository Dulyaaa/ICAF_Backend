package com.backend.cms.Service;

import com.backend.cms.Model.User;
import com.backend.cms.Model.Payment;
import com.backend.cms.Model.sampleMod;
import com.backend.cms.Repository.PaymentRepo;
import com.backend.cms.Repository.UserRepository;
import com.backend.cms.Repository.sampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class sampleServ {
    @Autowired
    public sampleRepo obj;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public PaymentRepo paymentRepo;



    public boolean testMethod(sampleMod sample){
        sampleMod result=obj.save(sample);
        if(result==null) {
            return false;
        }
        else {
            return true;
        }
    }
    public User saveUser(User user) {
        return  userRepository.save(user);
    }
    public Payment savePayment(Payment payment) { return  paymentRepo.save(payment); }

}
