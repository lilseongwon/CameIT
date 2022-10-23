package com.example.cameit.global.properties;

import com.example.cameit.global.security.jwt.JwtProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {JwtProperties.class})
public class EnableConfigurationPropertiesConfig {
}