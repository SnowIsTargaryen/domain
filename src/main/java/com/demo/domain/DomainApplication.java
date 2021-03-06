package com.demo.domain;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
//@EnableAdminServer
@EntityScan(basePackageClasses = {Jsr310Converters.class},basePackages = {"com.demo.domain"})
@SpringBootApplication
public class DomainApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainApplication.class, args);
    }

}
