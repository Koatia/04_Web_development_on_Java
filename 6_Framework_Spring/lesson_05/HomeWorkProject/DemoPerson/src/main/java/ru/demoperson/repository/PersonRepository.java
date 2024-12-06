package ru.demoperson.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.demoperson.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
