package com.sub.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**l
 * @Author sub
 * @Date 2021/5/30 16:48
 * @Version 1.0
 */
@RestController
@RefreshScope
public class ClientController {

    @Value("${config}")
    private  String configInfo;

    @GetMapping(value = "/configInfo")
    public String getConfigInfo() {
        return configInfo;
    }



}
