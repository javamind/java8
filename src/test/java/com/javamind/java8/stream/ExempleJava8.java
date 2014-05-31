package com.javamind.java8.stream;


import com.google.common.collect.Lists;
import com.javamind.domain.Person;
import com.javamind.stream.Mapper;
import com.javamind.stream.Predicate;
import com.javamind.stream.Reducer;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collection;

/**
 * Un exemple permettant de faire un tri sur une liste de personnes � la mode Java 7
 *
 * @author EHRET_G
 */
public class ExempleJava8 {

    private static Collection<Person> persons;

    @BeforeClass
    public static void init() {
        persons = Lists.newArrayList(
                new Person(10, "Luc"),
                new Person(20, "Sophie"),
                new Person(25, "C�line"),
                new Person(15, "Theo"),
                new Person(30, "Emilie"),
                new Person(70, "Paul"),
                new Person(50, "Elysabeth"),
                new Person(60, "Robert")
        );
    }



    @Test
    public void definitionLambda() {

        Mapper<Person, Integer> mapper = (Person person) -> person.getAge();
        //ou
        mapper = Person::getAge;

        Predicate<Integer> filter = i -> i>=20;

        Reducer<Integer> reducer = (r1, r2) -> r1+r2;

    }


    @Test
    public void calculAgeMoyenProgFonctionnelleJava8() {
        persons.stream()
                        .map(person -> person.getAge())
                        .filter(age -> age>=20)
                        .reduce(0, (age1, age2) -> age1 + age2);

    }
}
