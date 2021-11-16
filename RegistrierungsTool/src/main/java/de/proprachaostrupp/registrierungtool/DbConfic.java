package de.proprachaostrupp.registrierungtool;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DbConfic {
    @Bean
    DataSource getDataSource(){
        return DataSourceBuilder.create()
                .url("jdbc:mariadb://localhost:3306/Registrierung")
                .username("root")
                .password("123456789")
                .build();
    }
}
