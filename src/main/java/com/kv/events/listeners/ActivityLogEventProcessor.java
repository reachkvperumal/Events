package com.kv.events.listeners;

import com.kv.events.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class ActivityLogEventProcessor {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${activity-log.endpoint}")
    private String activityLog;

    @Async
    @EventListener(Person.class)
    public void handleLog(Person person) {
        long startTime = System.currentTimeMillis();
        String response = restTemplate.postForObject(activityLog, person, String.class);
        long endTime = System.currentTimeMillis();
        log.info("Response - {}, Time Taken: {} ms", response, (endTime - startTime));
    }


}
