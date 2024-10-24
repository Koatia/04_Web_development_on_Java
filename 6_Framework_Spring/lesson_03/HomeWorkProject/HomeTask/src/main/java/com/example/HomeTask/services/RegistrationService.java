package com.example.HomeTask.services;

import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    public RegistrationService(DataProcessingService dataProcessingService) {
        this.dataProcessingService = dataProcessingService;
    }

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    //    @Autowired
    private DataProcessingService dataProcessingService;

    //Поля UserService, NotificationService

    //Метод processRegistration
}
