package fz.fxq.finance.dao;

import fz.fxq.finance.po.UserBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalanceDAO extends JpaRepository<UserBalance, Long> {
}
