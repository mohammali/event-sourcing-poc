package com.mohammali.poc.eventsourcing.axongateway.app.config;

import com.mxninja.snowflake.Snowflake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Snowflake snowflake() {
        return new Snowflake(10);
    }
}
