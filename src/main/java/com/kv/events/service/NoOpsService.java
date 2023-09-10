package com.kv.events.service;

import com.kv.events.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class NoOpsService {

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public String apply(Person person) {
        log.info("{} , {}", person.getFirstName(), person.getLastName());
        eventPublisher.publishEvent(person);
        return "SUCCESS!";
    }

    @Cacheable(value = "infoDetails", cacheManager = "defaultCacheManager", key = "#root.methodName",
            unless = "#result == null")
    public List<Person> getAllInfo(Person p) {
        return List.of(new Person()); //example implementation
    }
}
