package fz.fxq.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@ApiModel("登录请求")
public class LoginReqVO {
    @ApiModelProperty("用户代码")
    @NotBlank(message = "用户代码不能为空")
    private String userId;
    @ApiModelProperty("用户密码")
    @NotBlank(message = "密码不能为空")
    @Length(min = 3)
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
