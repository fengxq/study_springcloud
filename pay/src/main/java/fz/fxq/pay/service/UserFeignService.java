package fz.fxq.pay.service;

import fz.fxq.pay.service.impl.UserFeignFactoryServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * fallback与fallbackFactory区别，fallback只是出错运行你指定的方法，拿不到错误信息，fallbackFactory可以拿到错误信息。
 */
//@FeignClient(value = "user-service",fallback = UserFeignServiceImpl.class)
@FeignClient(value = "user-service", fallbackFactory = UserFeignFactoryServiceImpl.class)
public interface UserFeignService {
    @GetMapping("userService/user1/info/get/{userId}")
    public String getUserInfo(@PathVariable String userId);
}
