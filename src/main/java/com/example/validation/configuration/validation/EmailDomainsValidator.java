package com.example.validation.configuration.validation;

import com.example.validation.configuration.annotation.EmailDomains;
import com.example.validation.configuration.properties.EmailDomainsProperties;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmailDomainsValidator implements ConstraintValidator<EmailDomains, String> {

    private final EmailDomainsProperties emailDomainsProperties;

    public void initialize(EmailDomains constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return emailDomainsProperties.getAllowed()
                .stream()
                .map(String::toLowerCase)
                .map(it -> "@" + it)
                .anyMatch(obj.toLowerCase()::endsWith);
    }
}
