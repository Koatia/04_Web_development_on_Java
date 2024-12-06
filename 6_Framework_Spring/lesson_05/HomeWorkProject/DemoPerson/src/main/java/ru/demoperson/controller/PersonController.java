package ru.demoperson.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.demoperson.model.Person;
import ru.demoperson.service.PersonServices;

import java.util.List;

@Controller
@AllArgsConstructor
public class PersonController {
    public PersonServices personServices;

    @GetMapping("/person")
    public String getPersons(Model model) {
        List<Person> persons = personServices.findAll();
        model.addAttribute("persons", persons);
        return "person-list";
    }
}
