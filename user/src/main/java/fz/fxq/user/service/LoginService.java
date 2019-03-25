package fz.fxq.user.service;

import fz.fxq.user.vo.LoginReqVO;

public interface LoginService {

    public long loginRedis(LoginReqVO loginReqVO);

    public long loginOracle(LoginReqVO loginReqVO);

    public long loginMybatis(LoginReqVO loginReqVO);
}
