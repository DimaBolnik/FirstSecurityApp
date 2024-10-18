package ru.bolnik.springsecurity.firstsecurityapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bolnik.springsecurity.firstsecurityapp.models.Person;

import java.util.Optional;

@Repository
public interface PeopleRepositories  extends JpaRepository<Person, Integer> {

    Optional<Person> findByUsername(String username);
}
