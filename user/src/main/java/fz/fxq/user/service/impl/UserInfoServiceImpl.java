package fz.fxq.user.service.impl;

import fz.fxq.user.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public String getUserInfo(String userId) {
        String userName = stringRedisTemplate.opsForValue().get(userId);

        logger.info("getUserInfo,userId[" + userId + "]userName[" + userName + "]");
        return "getUserInfo userId[" + userId + "]userName[" + userName + "] info ...";
    }

    @Override
    public int addUserInfo(String userId, String userName) {
        stringRedisTemplate.opsForValue().set(userId, userName);
        String result = stringRedisTemplate.opsForValue().get(userId);

        logger.info("addUserInfo,result=" + result);

        return 0;
    }
}
