package com.dex.burger.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "com.dex.burger" })
@EnableConfigurationProperties(PriceProperties.class)
public class ApplicationConfig {
}
