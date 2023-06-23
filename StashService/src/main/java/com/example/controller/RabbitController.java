package com.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/rabbit")
@Slf4j
public class RabbitController {

    private final AmqpTemplate template;

    public RabbitController(AmqpTemplate template) {
        this.template = template;
    }

    @PostMapping("/send")
    public @ResponseBody String send(@RequestBody String message){
        log.info("Send to user queue");
        template.convertAndSend("userQueue", message);
        return "Sent to userQueue queue";
    }
}

