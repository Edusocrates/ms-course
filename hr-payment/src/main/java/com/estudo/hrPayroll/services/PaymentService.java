package com.estudo.hrPayroll.services;

import com.estudo.hrPayroll.entities.Payment;
import com.estudo.hrPayroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${hr-worker.host}")
    private String workerHost;

    public Payment getPayment( Long workerId, Integer days){
        //utilizando o map para mapear a uri, e o HashMap que é uma classe composta igual o ArrayList
        Map<String,String> uriVariables = new HashMap<>();
        uriVariables.put("id",""+workerId);//insere os parametros os aspas converte para string dessa forma com +

        //primeiro vem a uri que eu vou buscar e depois o tipo de retorno dela, depois vem os parametros
        Worker worker = restTemplate.getForObject(workerHost+"workers/{id}",Worker.class,uriVariables);
        return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }

}
