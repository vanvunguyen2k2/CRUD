package com.example.crud.controller;

import com.example.crud.Dto.AccountDto;
import com.example.crud.Dto.MessageDto;
import com.example.crud.Dto.StatisticDto;
import com.example.crud.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/test")
@CrossOrigin("*")
public class TestKafkaController {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    @PostMapping("/new")
    public AccountDto newUser (@RequestBody AccountDto accountDto) {
        StatisticDto statisticDto = new StatisticDto("Acount" + accountDto.getEmail() + "is created", new Date());
        System.out.println(statisticDto);

        // send notification
        MessageDto messageDto = new MessageDto();
        messageDto.setTo(accountDto.getEmail());
        messageDto.setToName(accountDto.getName());
        messageDto.setSubject("abc");
        messageDto.setContent("abc");

        kafkaTemplate.send("notification", messageDto);
        kafkaTemplate.send("statistic", statisticDto);


        return accountDto;
    }

}
