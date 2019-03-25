package fz.fxq.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("登录请求")
public class LoginReqVO {
    @ApiModelProperty("用户代码")
    private String userId;
    @ApiModelProperty("用户密码")
    private String userPwd;

    @Override
    public String toString() {
        return "userId[" + userId + "]userPwd[" + userPwd + "]";
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

}
