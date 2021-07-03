package com.backend.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.backend.cms.Model.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({ FileStorageProperties.class })
public class CmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CmsApplication.class, args);
    }

}
