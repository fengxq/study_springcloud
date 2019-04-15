package fz.fxq.commoditystarter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("commodity.service")
public class StarterServiceProperties {
    private String config;

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }
}
