package com.example.validation.configuration;

import com.example.validation.configuration.properties.DefaultsProperties;
import com.example.validation.configuration.properties.EmailDomainsProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        DefaultsProperties.class,
        EmailDomainsProperties.class
})
public class PropertiesConfiguration {
}
