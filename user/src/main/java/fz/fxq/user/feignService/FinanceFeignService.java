package fz.fxq.user.feignService;

import fz.fxq.user.feignService.impl.FinanceFeignFactoryServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "finance-service", fallbackFactory = FinanceFeignFactoryServiceImpl.class)
public interface FinanceFeignService {
    @GetMapping("financeService/user/balance/{userId}")
    public String getUserBalance(@PathVariable("userId") String userId);

    @GetMapping("financeService/user/pay/result/{userId}")
    public String getUserPayResult(@PathVariable String userId);
}
