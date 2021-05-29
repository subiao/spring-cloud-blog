package com.example.springclouddubboconsumer;

import com.sub.IHelloService;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sub
 * @Date 2021/4/22 16:16
 * @Version 1.0
 */
@RestController
public class HelloController {
    @Reference
    private IHelloService helloService;
    @GetMapping("/say")
    public String say(){
        return  helloService.sayHello("你好");
    }
}
