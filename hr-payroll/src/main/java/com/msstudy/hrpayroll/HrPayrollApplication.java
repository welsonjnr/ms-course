package com.msstudy.hrpayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
// Não precisa mais do Ribbon o Eureka tem o próprio balanceador de carga
//@RibbonClient(name = "hr-worker")
@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
public class HrPayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApplication.class, args);
	}

}
