package com.example.validation.configuration.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Validated
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties("email.domains")
public class EmailDomainsProperties {
    @NotNull
    private List<String> allowed;
}
