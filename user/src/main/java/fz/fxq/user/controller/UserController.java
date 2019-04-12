package fz.fxq.user.controller;

import fz.fxq.user.feignService.FinanceFeignService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user/restful")
public class UserController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FinanceFeignService financeFeignService;

    @RequestMapping("userPage.html")
    public String userList() {

        return "userPage";
    }

    @RequestMapping("list/query")
    @ResponseBody
    public List<Map<String, String>> getUserList() {
        List<Map<String, String>> userList = new ArrayList<>();
        userList.add(new HashMap<String, String>() {
            {
                put("userId", "userId1");
                put("userName", "userName1");
            }
        });
        userList.add(new HashMap<String, String>() {
            {
                put("userId", "userId2");
                put("userName", "userName2");
            }
        });
        return userList;
    }

    @RequestMapping("finance/balance")
    @ResponseBody
    public String getUserFinanceBalance() {
        String result = financeFeignService.getUserBalance("userId");
        return result;
    }

    @RequestMapping("pay/result")
    @ResponseBody
    public String getUserPayResult() {
        String result = financeFeignService.getUserPayResult("userId");
        return result;
    }

}
