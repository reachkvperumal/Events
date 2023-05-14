package com.kv.events.controller;

import com.kv.events.dto.Person;
import com.kv.events.service.NoOpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EventController {

    @Autowired
    private NoOpsService service;

    @PostMapping("/log")
    public String create(@RequestBody Person person) {
        return service.apply(person);
    }
}
