package com.outwit.elune.portal.sample;

import com.alibaba.dubbo.config.annotation.Reference;
import com.outwit.elune.service.sample.HelloService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @Reference(version = "1.0.0")
    private HelloService helloService;

    @RequestMapping(value = "/{user}", method = RequestMethod.GET)
    public String getHelloMessage(@PathVariable String user) {
        return helloService.sayHello(user);
    }
}
