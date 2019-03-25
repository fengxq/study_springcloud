package fz.fxq.user.dao;

import fz.fxq.user.po.UserPO;

import java.util.List;

public interface LoginDAO {
    public List<UserPO> getUserPOList();

    public UserPO getUserPO(String userId);
}
