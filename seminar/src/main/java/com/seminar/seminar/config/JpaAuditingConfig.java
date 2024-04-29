package com.seminar.seminar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //모든 어플리케이션에 대해 적용됨
@EnableJpaAuditing
public class JpaAuditingConfig {

}
