package com.example.donation.challenge.fullstack.infra.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = " DAS - Donation API",
                version = "v1",
                contact = @Contact(
                        name = "Vinicius Rodrigues",
                        email = "viniciusysrodrigues@gmail.com")
        ))
public class OpenApiConfiguration {}
