package com.example.validation.configuration.properties;

import com.example.validation.configuration.annotation.EmailDomains;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Validated
@ConstructorBinding
@AllArgsConstructor
@ConfigurationProperties("defaults")
public class DefaultsProperties {
    @NotNull
    private Author author;

    @Getter
    @AllArgsConstructor
    public static class Author {
        @NotBlank
        private String name;
        @NotBlank @Email @EmailDomains
        private String email;
    }
}
