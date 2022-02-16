package com.doughdesgin.doughmanagement.config;

import org.slf4j.*;
import org.springframework.beans.factory.InjectionPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.MethodParameter;

import java.lang.reflect.Field;

import static java.util.Optional.*;

@Configuration
@ComponentScan(basePackages = "com.doughdesgin.doughmanagement")
public class DefaultConfig {

    @Bean
    @Scope("prototype")
    public Logger logger(final InjectionPoint ip) {
        return LoggerFactory.getLogger(of(ip.getMethodParameter())
                .<Class>map(MethodParameter::getContainingClass)
                .orElseGet( () ->
                        ofNullable(ip.getField())
                                .map(Field::getDeclaringClass)
                                .orElseThrow (IllegalArgumentException::new)
                )
        );
    }
}
