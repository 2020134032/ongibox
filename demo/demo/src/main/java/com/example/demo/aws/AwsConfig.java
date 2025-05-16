package com.example.demo.aws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;

@Configuration
public class AwsConfig {

    @Bean
    S3Presigner s3Presigner(@Value("${spring.cloud.aws.region.static}") String region) {
        return S3Presigner.builder()
                .region(Region.of(region))
                .build();              // creds auto-picked (EC2 role or env vars)
    }
}
