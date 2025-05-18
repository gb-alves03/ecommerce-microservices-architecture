package com.alves.customer.infra.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.alves.customer.adapters.out.repository")
public class DatabaseConfig {
}
