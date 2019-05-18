package com.polytech.polynetwork;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.polytech.polynetwork.application.*;
import com.polytech.polynetwork.data.InMemoryStoryRepository;
import com.polytech.polynetwork.data.JdbcStoryRepository;
import com.polytech.polynetwork.data.JpaStoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class AppConfig {

    @Bean
    com.polytech.polynetwork.StoryRepository storyRepository() {

        return new JpaStoryRepository();
    }
    @Bean
    DataSource datasource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://localhost:3306/polynet");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setDatabaseName("polynet");
        return dataSource;
    }
    @Bean
    FeedService feedService(){
        return new FeedServiceImp(storyRepository());
    }

    @Bean
    PublicationService publicationService(){
        return new PublicationServiceImpl(storyRepository());
    }

    @Bean
    RegisterService registerService(){
        return new RegisterServiceImp(storyRepository());
    }

}