package com.example.crud;

//import org.apache.kafka.clients.admin.NewTopic;
//import org.apache.kafka.common.utils.AppInfoParser;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableScheduling
public class CrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudApplication.class, args);
    }

//    @Bean
//    NewTopic notificaition() {
//        return new NewTopic("notification" , 2, (short)  1);
//    }
//
//
//    @Bean
//    NewTopic statistic () {
//        return new NewTopic("statistic", 1, (short)  1);
//    }

    @Bean
    JsonMessageConverter converter () {
        return new JsonMessageConverter();
    }


}
