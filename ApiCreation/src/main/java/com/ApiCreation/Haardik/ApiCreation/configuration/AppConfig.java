package com.ApiCreation.Haardik.ApiCreation.configuration;

import com.ApiCreation.Haardik.ApiCreation.DB;
import com.ApiCreation.Haardik.ApiCreation.DevDB;
import com.ApiCreation.Haardik.ApiCreation.ProdDB;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//In this file you'll see multiple beans being defined.
@Configuration
public class AppConfig {

    //NOTE: @Bean are used to prevent you from using "new" keyword in your code.
    @Bean //This bean will be used to return a DevDB instance
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    //When application.properties has app.environment=development, this bean will be used.
    public DB getDevDBBean() {
        return new DevDB();
    }

    @Bean //This bean will be used to return a ProdDB instance
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    //When application.properties has app.environment=production, this bean will be used.
    public DB getProdDBBean() {
        return new ProdDB();
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
