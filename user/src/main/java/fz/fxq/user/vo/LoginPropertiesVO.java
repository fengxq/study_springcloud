package fz.fxq.user.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:login.properties")
@ConfigurationProperties(prefix = "login")
public class LoginPropertiesVO {

    /**
     * 登录次数
     */
    @Value("${login.times}")
    private String loginTimes;

    public String getLoginTimes() {
        return loginTimes;
    }

    public void setLoginTimes(String loginTimes) {
        this.loginTimes = loginTimes;
    }
}
