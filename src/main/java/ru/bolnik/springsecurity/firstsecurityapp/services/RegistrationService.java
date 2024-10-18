package ru.bolnik.springsecurity.firstsecurityapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bolnik.springsecurity.firstsecurityapp.models.Person;
import ru.bolnik.springsecurity.firstsecurityapp.repositories.PeopleRepositories;

@Service
public class RegistrationService {

    private final PeopleRepositories peopleRepositories;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PeopleRepositories peopleRepositories, PasswordEncoder passwordEncoder) {
        this.peopleRepositories = peopleRepositories;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person) {
        String encode = passwordEncoder.encode(person.getPassword());
        person.setPassword(encode);
        person.setRole("ROLE_USER");
        peopleRepositories.save(person);
    }
}
