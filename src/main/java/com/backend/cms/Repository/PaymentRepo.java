package com.backend.cms.Repository;

import com.backend.cms.Model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepo extends MongoRepository<Payment,String> {
    public Payment save(Payment payment);

}
