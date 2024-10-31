package ru.demoperson.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.demoperson.model.Person;
import ru.demoperson.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonServices {
    private PersonRepository personRepository;

    /**
     * Получить всех person
     *
     * @return список person
     */
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    /**
     * Найти person по id
     *
     * @param id ID
     * @return person
     */
    public Person findById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Person updatePerson(Long id, Person personDetails) {
        Optional<Person> personOptional = personRepository.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.setFirstName(personDetails.getFirstName());
            person.setLastName(personDetails.getLastName());
            person.setEmail(personDetails.getEmail());
            return personRepository.save(person);
        } else {
            throw new IllegalArgumentException("Person not found with id " + id);
        }
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
