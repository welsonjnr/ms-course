package com.msstudy.hrpayroll.services;

import com.msstudy.hrpayroll.entities.Payment;
import com.msstudy.hrpayroll.entities.Worker;
import com.msstudy.hrpayroll.feignClient.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    //#########################################################################################################//
//    @Value("${hr.worker.host}")
//    private String workerHost;

//    @Autowired
//    private RestTemplate restTemplate;

//    Método com a implementação RestTeamplate
//    RestTeamplate era usado antes do Spring Cloud.
//    Isso não é MS, ms é você só colocar o nome do serviço e a prórpia infraestrutura resolve isso para você.

//    public Payment getPayment(long workerId, int days){
//
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("id", "" + workerId);
//
//        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
//
//        return new Payment(worker.getName(), worker.getDailyIncome(), days);
//    }
    //#########################################################################################################//

    public Payment getPayment(long workerId, int days){

        Worker worker = workerFeignClient.findById(workerId).getBody();

        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
