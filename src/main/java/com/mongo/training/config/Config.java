package com.mongo.training.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final MongoClient mongoClient;

    @Value("${spring.data.mongodb.database}")
    private String dataBaseName;

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient, dataBaseName);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
