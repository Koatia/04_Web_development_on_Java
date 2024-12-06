package ru.example1;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    //Конструктор может быть заменен @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        userRepository.save(new User(null, "Petr", "petr@mail.ru"));
        userRepository.save(new User(null, "Oleg", "segas@mail.ru"));
        userRepository.save(new User(null, "Olia", "sdhsd@mail.ru"));
        userRepository.save(new User(null, "Sveta", "qwwwf@mail.ru"));

        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id);
    }
}
