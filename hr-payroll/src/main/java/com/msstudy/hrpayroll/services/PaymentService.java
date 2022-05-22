package com.msstudy.hrpayroll.services;

import com.msstudy.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(Long workerId, int days){
        return new Payment("Bob", 200.00, days);
    }
}
