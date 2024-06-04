package com.example.crud.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduledTasks {

//    @Scheduled(cron = "1 * * * * *")
    public void runMyTask () {
        System.out.println("abc");
    }
}
