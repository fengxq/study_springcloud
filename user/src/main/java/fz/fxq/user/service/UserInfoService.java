package fz.fxq.user.service;

public interface UserInfoService {

    public String getUserInfo(String userId);

    public int addUserInfo(String userId, String userName);
}
