package fz.fxq.commoditystarter.config;

import fz.fxq.commoditystarter.service.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(StarterService.class)//当classpath下发现该类的情况下进行自动配置
@EnableConfigurationProperties(StarterServiceProperties.class)
public class StarterAutoConfigure {
    @Autowired
    private StarterServiceProperties starterServiceProperties;

    @Bean
    @ConditionalOnMissingBean//当Spring Context中不存在该Bean时
    @ConditionalOnProperty(prefix = "commodity.service", value = "enabled", havingValue = "true")//commodity.service.enabled=true时
    StarterService starterService() {
        return new StarterService(starterServiceProperties.getConfig());
    }
}
