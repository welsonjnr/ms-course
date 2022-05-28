package com.msstudy.hrpayroll.services;

import com.msstudy.hrpayroll.entities.Payment;
import com.msstudy.hrpayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Value("${hr.worker.host}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    //Método com a implementação RestTeamplate
    //RestTeamplate era usado antes do Spring Cloud.
    //Isso não é MS, ms é você só colocar o nome do serviço e a prórpia infraestrutura resolve isso para você.
    public Payment getPayment(long workerId, int days){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", "" + workerId);

        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
