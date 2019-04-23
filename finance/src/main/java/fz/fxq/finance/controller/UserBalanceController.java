package fz.fxq.finance.controller;

import fz.fxq.finance.po.UserBalance;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping("balance")
public class UserBalanceController {
    List<UserBalance> userBalanceList = new ArrayList<>();

    public UserBalanceController() {
        UserBalance userBalance = new UserBalance();
        userBalance.setId(System.currentTimeMillis());
        userBalance.setName("test1");
        userBalance.setBalance(101.02);
        userBalanceList.add(userBalance);
    }

    @GetMapping("userBalanceList.html")
    public String userBalance() {
        return "balance/userBalanceList";
    }

    @PostMapping("userBalance")
    public String userBalance(Model model) {
        model.addAttribute("userBalanceList", userBalanceList);
        return "balance/userBalanceList";
    }

    @PostMapping("inMoney")
    public String inMoney(Model model) {
        UserBalance userBalance = new UserBalance();
        userBalance.setId(System.currentTimeMillis());
        userBalance.setName("test2");
        userBalance.setBalance(102.02);
        userBalanceList.add(userBalance);
        model.addAttribute("userBalanceList", userBalanceList);
        return "balance/userBalanceList";
    }
}
