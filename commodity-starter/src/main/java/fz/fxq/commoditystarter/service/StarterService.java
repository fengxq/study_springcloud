package fz.fxq.commoditystarter.service;

import org.springframework.util.StringUtils;

public class StarterService {
    private String config;

    public StarterService(String config) {
        this.config = config;
    }

    public String[] split(String separatorChar) {
        return StringUtils.split(config, separatorChar);
    }
}
