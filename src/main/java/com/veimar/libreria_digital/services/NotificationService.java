package com.veimar.libreria_digital.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    // TAREA 2.2.1 Create a bean in the Notifications microservice and use @PostConstruct to execute a method immediately after initialization.
    @PostConstruct
    public void notifica() {
        System.out.println("Post construct NotificationService");
    }

}
