/**
 *
 */
package com.wise.springcloud.controller;

import com.wise.springcloud.entities.CommonResult;
import com.wise.springcloud.entities.Payment;
import com.wise.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        if(i > 0){
            return new CommonResult(200,"创建成功",payment);
        }else{
            return new CommonResult(400,"failed");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult get(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if(payment != null){
            return new CommonResult(200,"成功1",payment);
        }else{
            return new CommonResult(400,"failed");
        }
    }
}
