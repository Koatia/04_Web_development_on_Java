package com.example.HomeTask.controllers;

import com.example.HomeTask.domain.User;
import com.example.HomeTask.services.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")  //localhost:8080/user
public class UserController {

    //    @Autowired
    private RegistrationService service;

    //конструкторная инъекция вместо @Autowired
    public UserController(RegistrationService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> userList() {
        return service.getAllUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
//        service.getDataProcessingService().getRepository().getUsers().add(user);
        return service.addUser(user);
    }

    @PostMapping("/add/{name}/{age}/{email}")
    public String userAdd(
            @PathVariable String name,
            @PathVariable int age,
            @PathVariable String email) {
        service.processRegistration(name, age, email);
        return "User added!";
    }
}
