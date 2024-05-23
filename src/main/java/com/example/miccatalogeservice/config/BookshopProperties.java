package com.example.miccatalogeservice.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bookshop")
@Getter
@Setter
public class BookshopProperties {

    private String greeting;

}
