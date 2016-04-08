package org.home.test.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AppInfoService {
    private static final Logger LOG = LoggerFactory.getLogger(AppInfoService.class);

    @Value("${app.name}")
    private String appName;

    @Value("${app.version}")
    private String appVersion;

    public void printAppInfo(){
        LOG.info("Application name = " + appName);
        LOG.info("Application version = " + appVersion);
    }

}
