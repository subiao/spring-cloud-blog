package com.sub.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sub.entity.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**l
 * @Author sub
 * @Date 2021/5/30 16:48
 * @Version 1.0
 */
@RestController
public class RateLimitController {



    @GetMapping(value = "/byResource")
    @SentinelResource(value="byResource",blockHandler = "handleException")
    public CommonResult getConfigInfo() {
        return new CommonResult(200,"限流测试成功！");
    }

    public CommonResult handleException(BlockException e) {
        return new CommonResult(444,e.getClass().getCanonicalName()+"服务不可用！");
    }

    /**
     * 用户自定义hanlder类处理异常
     * @return
     */
    @GetMapping(value = "/customBlockHandler")
    @SentinelResource(value="customBlockHandler",blockHandlerClass = CustomBlockHandler.class ,blockHandler = "blockHandler1")
    public CommonResult customBlockHandler() {
        return new CommonResult(200,"用户自定义类处理异常！");
    }

}
