/**
 *
 */
package com.wise.springcloud.controller;

import com.wise.springcloud.entities.CommonResult;
import com.wise.springcloud.entities.Payment;
import com.wise.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if(i > 0){
            return new CommonResult(200,"创建成功,端口号" + serverPort,payment);
        }else{
            return new CommonResult(400,"failed");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"成功1，端口号" + serverPort,payment);
        }else{
            return new CommonResult(400,"failed");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("****element" + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId() + instance.getHost() + instance.getPort());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPamentLB(){
        return serverPort;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
//        try{
//            TimeUnit.SECONDS.sleep(1);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        return serverPort;
    }
}
