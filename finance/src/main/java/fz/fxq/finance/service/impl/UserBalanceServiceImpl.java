package fz.fxq.finance.service.impl;

import fz.fxq.finance.dao.UserBalanceDAO;
import fz.fxq.finance.po.UserBalance;
import fz.fxq.finance.service.UserBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBalanceServiceImpl implements UserBalanceService {
    @Autowired
    UserBalanceDAO userBalanceDAO;

    @Override
    public List<UserBalance> getUserBalanceList() {
        return userBalanceDAO.findAll();
    }

}
