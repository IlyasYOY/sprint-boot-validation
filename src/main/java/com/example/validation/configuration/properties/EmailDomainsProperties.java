package com.example.validation.configuration.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Validated
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties("email.domains")
public class EmailDomainsProperties {
    @NotNull
    private Set<String> allowed;

    @AssertTrue
    boolean allDomainsContainDot() {
        return allowed.stream()
                .anyMatch(s -> !s.contains("."));
    }
}
