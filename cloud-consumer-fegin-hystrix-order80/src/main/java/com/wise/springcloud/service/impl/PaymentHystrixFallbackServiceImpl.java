package com.wise.springcloud.service.impl;

import com.wise.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixFallbackServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return " --------- PaymentHystrixFallbackServiceImpl paymentInfo_OK";
    }

    @Override
    public String paymentInfo_timeOut(Integer id) {
        return " --------- PaymentHystrixFallbackServiceImpl paymentInfo_timeOut";
    }
}
