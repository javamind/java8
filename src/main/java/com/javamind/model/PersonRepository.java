package com.javamind.model;

import com.javamind.domain.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * {@link }
 *
 * @author EHRET_G
 */
public class PersonRepository {

    //Our names
    private List<Person> winners = Arrays.asList(
            new Person(25, "Paul"),
            new Person(35, "Sylvie"),
            new Person(15, "Mathilde")
    );

    /**
     * The bad way
     *
     * @param name
     * @return
     */
    public Person getWinnerByName(String name) {
        for (Person p : winners) {
            if (name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }

    /**
     * With optional
     * @param name
     * @return
     */
    public Optional<Person> getWinnerByName2(String name){
        for(Person p : winners){
            if(name.equals(p.getName())){
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    /**
     * The best way
     * @param name
     * @return
     */
    public Optional<Person> getWinnerByName3(String name){
        return winners.stream().filter(p -> name.equals(p.getName())).findFirst();
    }
}
