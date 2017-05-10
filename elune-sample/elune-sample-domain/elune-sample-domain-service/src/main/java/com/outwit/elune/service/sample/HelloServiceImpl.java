package com.outwit.elune.service.sample;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "1.0.0", retries = 2, timeout = 2000)
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "Hello , " + name;
    }
}
