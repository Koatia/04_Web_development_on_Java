package com.example.demo.repositories;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигуратор SQL запросов
 */
@Configuration
@ConfigurationProperties(prefix = "sqlcmd")
@Data
public class SqlCMD {
    private String findAll;
    private String save;
    private String deleteById;
    private String update;
    private String getUserById;

}
