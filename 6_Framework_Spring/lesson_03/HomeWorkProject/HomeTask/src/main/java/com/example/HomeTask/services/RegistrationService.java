package com.example.HomeTask.services;

import com.example.HomeTask.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    //Поля UserService, NotificationService
    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    private UserService userService;
    @Autowired
    private NotificationService notificationService;


    public RegistrationService(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    public List<User> getAllUsers() {
        return dataProcessingService.getRepository().getUsers();
    }

    public String addUser(User user) {
        dataProcessingService.getRepository().getUsers().add(user);
        return "User added from body!";
    }

    //Метод processRegistration
    public void processRegistration(String name, int age, String email) {
        User user = userService.createUser(name, age, email);
        notificationService.notifyUser(user);

        dataProcessingService.addUserToList(user);
        notificationService.sendNotification("User " + user.getName() + " has been added successfully");
    }
}
