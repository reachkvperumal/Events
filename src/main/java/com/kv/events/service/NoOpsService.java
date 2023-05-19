package com.kv.events.service;

import com.kv.events.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NoOpsService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public String apply(Person person) {
       log.info("{} , {}", person.getFirstName(), person.getLastName());
        eventPublisher.publishEvent(person);
        person.setStatus("CREATED");
        return person;
    }
}
