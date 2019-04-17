package fz.fxq.user.config.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ShiroRealm extends AuthorizingRealm {
    Logger logger = LoggerFactory.getLogger(ShiroRealm.class);

    /**
     * 权限授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo......");
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> stringPermissionsSet = new HashSet<>();

        UserInfo userInfo = (UserInfo) principalCollection.getPrimaryPrincipal();
        logger.info("doGetAuthorizationInfo......userInfo[" + userInfo + "]");
        logger.info("doGetAuthorizationInfo......userInfo.getUserName[" + userInfo.getUserName() + "]");

        //获取该用户的权限信息
        stringPermissionsSet.add("login:shiro:login.html");
        stringPermissionsSet.add("user:restful:list:query");

        simpleAuthorizationInfo.setStringPermissions(stringPermissionsSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     * 1、检查提交的进行认证的令牌信息
     * 2、根据令牌信息从数据源(通常为数据库)中获取用户信息
     * 3、对用户信息进行匹配验证。
     * 4、验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
     * 5、验证失败则抛出AuthenticationException异常信息。
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo......");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String userName = usernamePasswordToken.getUsername();
        logger.info("doGetAuthenticationInfo......userName[" + userName + "]");

        if (!"fxqtest".equals(userName)) {
            throw new UnknownAccountException("账号不存在");
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("fxqtest");
        userInfo.setUserPassword("123");
        userInfo.setSalt("abc");

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userInfo, userInfo.getUserPassword(), ByteSource.Util.bytes(userInfo.getSalt()), getName());

        return simpleAuthenticationInfo;
    }

}
