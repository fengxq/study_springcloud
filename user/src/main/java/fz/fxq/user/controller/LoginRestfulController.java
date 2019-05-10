package fz.fxq.user.controller;

import fz.fxq.user.service.LoginService;
import fz.fxq.user.vo.LoginPropertiesVO;
import fz.fxq.user.vo.LoginReqVO;
import fz.fxq.user.vo.LoginResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login/restful")
@Api("用户登录")
public class LoginRestfulController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    LoginService loginService;
    @Autowired
    LoginPropertiesVO loginPropertiesVO;

    @PostMapping("submit/redis")
    @ApiOperation("提交Redis")
    public LoginResultVO loginRedis(@RequestBody @Validated LoginReqVO loginReqVO, BindingResult bindingResult) {
        logger.info("loginRedis,loginReqVO[" + loginReqVO + "]");
        LoginResultVO loginResultVO = new LoginResultVO();

        loginService.loginRedis(loginReqVO);

        loginResultVO.setCode(0);
        loginResultVO.setMsg("success");

        logger.info("loginPropertiesVO.loginTimes[" + loginPropertiesVO.getLoginTimes() + "]");
        logger.info("bindingResult[" + bindingResult.toString() + "]");
        logger.info("bindingResult getAllErrors[" + bindingResult.getAllErrors());

        if (bindingResult.hasErrors()) {
            loginResultVO.setMsg(bindingResult.getAllErrors() + "");
        }

        return loginResultVO;
    }

    @PostMapping("submit/oracle")
    @ApiOperation("提交Oracle")
    public LoginResultVO loginOracle(@RequestBody LoginReqVO loginReqVO) {
        logger.info("loginOracle,loginReqVO[" + loginReqVO + "]");
        LoginResultVO loginResultVO = new LoginResultVO();

        loginService.loginOracle(loginReqVO);

        loginResultVO.setCode(0);
        loginResultVO.setMsg("success");

        return loginResultVO;
    }

    @PostMapping("submit/mybatis")
    @ApiOperation("提交Mybatis")
    public LoginResultVO loginMybatis(@RequestBody LoginReqVO loginReqVO) {
        logger.info("loginMybatis,loginReqVO[" + loginReqVO + "]");
        LoginResultVO loginResultVO = new LoginResultVO();

        loginService.loginMybatis(loginReqVO);

        loginResultVO.setCode(0);
        loginResultVO.setMsg("success");

        return loginResultVO;
    }

}
