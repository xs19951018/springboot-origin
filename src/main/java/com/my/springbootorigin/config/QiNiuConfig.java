package com.my.springbootorigin.config;

import com.qiniu.common.Zone;
import org.springframework.beans.factory.annotation.Value;

public class QiNiuConfig {

    @Value("${qiniu.accessKey}")
    private String accessKey;
    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Value("${qiniu.bucket}")
    private String bucket;
    @Value("${qiniu.zone}")
    private Zone zone;
    @Value("${qiniu.domain}")
    private String domain;
    @Value("${qiniu.expire}")
    private long expire;

    private static QiNiuConfig instance = new QiNiuConfig();

    public static QiNiuConfig getInstance(){
        return instance;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public String getBucket() {
        return bucket;
    }

    public Zone getZone() {
        return zone;
    }

    public String getDomain() {
        return domain;
    }

    public long getExpire() {
        return expire;
    }
}
