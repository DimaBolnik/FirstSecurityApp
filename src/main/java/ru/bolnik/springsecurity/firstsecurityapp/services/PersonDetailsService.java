package ru.bolnik.springsecurity.firstsecurityapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.bolnik.springsecurity.firstsecurityapp.models.Person;
import ru.bolnik.springsecurity.firstsecurityapp.repositories.PeopleRepositories;
import ru.bolnik.springsecurity.firstsecurityapp.security.PersonDetails;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PeopleRepositories peopleRepositories;

    public PersonDetailsService(PeopleRepositories peopleRepositories) {
        this.peopleRepositories = peopleRepositories;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> byUsername = peopleRepositories.findByUsername(username);

        if (byUsername.isEmpty()) {
            throw new UsernameNotFoundException("user not found!");
        }
        return new PersonDetails(byUsername.get());
    }
}
