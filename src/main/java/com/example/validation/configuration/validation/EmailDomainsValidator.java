package com.example.validation.configuration.validation;

import com.example.validation.configuration.annotation.EmailDomains;
import com.example.validation.configuration.properties.EmailDomainsProperties;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class EmailDomainsValidator implements ConstraintValidator<EmailDomains, String> {

    public static final String AT_SYMBOL = "@";

    private final EmailDomainsProperties emailDomainsProperties;

    @Override
    public void initialize(EmailDomains constraint) {
    }

    @Override
    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return emailDomainsProperties.getAllowed()
                .stream()
                .map(String::toLowerCase)
                .map(it -> AT_SYMBOL + it)
                .anyMatch(obj.toLowerCase()::endsWith);
    }
}