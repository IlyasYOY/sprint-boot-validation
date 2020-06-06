package com.example.validation.configuration;

import com.example.validation.configuration.properties.DefaultsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        DefaultsProperties.class
})
public class PropertiesConfiguration {
}
