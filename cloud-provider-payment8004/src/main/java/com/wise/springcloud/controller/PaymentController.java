/**
 *
 */
package com.wise.springcloud.controller;

import com.wise.springcloud.entities.CommonResult;
import com.wise.springcloud.entities.Payment;
import com.wise.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentZk(){
        return "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
    }

//    @PostMapping("/payment/create")
//    public CommonResult create(@RequestBody Payment payment){
//        int i = paymentService.create(payment);
//        if(i > 0){
//            return new CommonResult(200,"创建成功,端口号" + serverPort,payment);
//        }else{
//            return new CommonResult(400,"failed");
//        }
//    }

//    @GetMapping("/payment/get/{id}")
//    public CommonResult get(@PathVariable("id") Long id){
//        Payment payment = paymentService.getPaymentById(id);
//        if(payment != null){
//            return new CommonResult(200,"成功1，端口号" + serverPort,payment);
//        }else{
//            return new CommonResult(400,"failed");
//        }
//    }
}
