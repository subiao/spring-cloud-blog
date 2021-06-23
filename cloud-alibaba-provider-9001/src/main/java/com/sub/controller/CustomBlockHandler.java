package com.sub.controller;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sub.entity.CommonResult;

/**
 * @Author sub
 * @Date 2021/6/23 16:05
 * @Version 1.0
 */
public class CustomBlockHandler {
    public  static CommonResult blockHandler1(BlockException e){
        return new CommonResult(200,"用户自定义处理类blockHandler1");
    }

    public  static CommonResult blockHandler2(BlockException e){
        return new CommonResult(200,"用户自定义处理类blockHandler2");
    }

}
