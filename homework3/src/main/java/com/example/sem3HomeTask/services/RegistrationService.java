package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    UserService userService;
    NotificationService notificationService;

    public void processRegistration(String name, int age,String email){
        User user = userService.createUser(name,age,email);
        dataProcessingService.addUserToList(user);
    }
}
