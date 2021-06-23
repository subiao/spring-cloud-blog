package com.sub.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sub.entity.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author sub
 * @Date 2021/6/23 16:25
 * @Version 1.0
 */
@RestController
public class FallBackController {
    @RequestMapping("/fallback/{id}")
    @SentinelResource(value = "back", fallback = "back",blockHandler = "block")
    public CommonResult fallback(@PathVariable Long id) {
        if (id == 4) {
            throw new IllegalArgumentException("参数异常");
        } else if (id == 5) {
            throw new NullPointerException("空指针异常");
        }
        return new CommonResult(200, "正常降级！");
    }

    public   CommonResult back(@PathVariable Long id, Throwable e){

        return new CommonResult(200,"降级id"+id+"降级异常类"+e.getMessage());
    }

    public   CommonResult block(@PathVariable Long id, BlockException e){

        return new CommonResult(200,"降级id"+id+"限流异常类"+e.getMessage());
    }

}
