package com.tyb1222.service.impl;

import com.tyb1222.service.LogService;
import org.springframework.stereotype.Service;

@Service(value = "logService")
public class LogServiceImpl implements LogService {

    public void info(String info) {
        System.out.println("logService write log ;" + info);
    }

    public void error(String errorInfo) {
        System.out.println("error occur ;" + errorInfo);
    }
}
