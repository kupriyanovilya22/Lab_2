package com.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rabbit")
@Slf4j
public class RabbitController {

    private final AmqpTemplate template;

    @Autowired
    public RabbitController(AmqpTemplate template) {
        this.template = template;
    }

    @PostMapping("/send")
    public ResponseEntity<String> send(@RequestBody String message) {
        log.info("Sending message to storage queue");
        template.convertAndSend("storageQueue", message);
        return ResponseEntity.status(HttpStatus.OK).body("Message sent to storage queue");
    }
}

