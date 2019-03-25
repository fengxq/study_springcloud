package fz.fxq.user.mapper;

import fz.fxq.user.po.UserPO;

import java.util.List;

public interface LoginMapper {
    public List<UserPO> getUserPOList();

    public UserPO getUserPO(String userId);
}
