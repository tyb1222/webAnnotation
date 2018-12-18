package com.tyb1222.service.impl;

import com.tyb1222.service.MessageService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Async
    public void sendEmail(String msg) {
        System.out.println(Thread.currentThread().getName()+"send message" + msg);
    }
}
