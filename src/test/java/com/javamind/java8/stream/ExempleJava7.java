package com.javamind.java8.stream;


import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import com.javamind.domain.Person;
import com.javamind.stream.Mapper;
import com.javamind.stream.Predicate;
import com.javamind.stream.Reducer;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

/**
 * Un exemple permettant de faire un tri sur une liste de personnes � la mode Java 7
 *
 * @author EHRET_G
 */
public class ExempleJava7 {

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
    public void calculAgeMoyenProgImperative() {
        int sum = 0;
        int average = 0;
        int nb = 0;
        for (Person p : persons) {
            if (p.getAge() >= 20) {
                sum += p.getAge();
                nb++;
            }
        }
        if (!persons.isEmpty()) {
            average = sum / nb;
        }

        Assertions.assertThat(average).isEqualTo(42);
    }

    @Test
    public void calculAgeMoyenProgFonctionnelleJava7() {
        Mapper<Person, Integer> mapper = new Mapper<Person, Integer>() {
            @Override
            public Integer map(Person o) {
                return o.getAge();
            }
        };
        Predicate<Integer> filter = new Predicate<Integer>() {
            @Override
            public boolean filter(Integer t) {
                return t>=20;
            }
        };
        Reducer<Integer> reducer = new Reducer<Integer>() {
            @Override
            public Integer reduce(Integer r1, Integer r2) {
                return r1+r2;
            }
        };

    }


    @Test
    public void calculAgeMoyenProgFonctionnelleGuava() {

        List<Integer> agesPersons = FluentIterable
                .from(persons)
                .filter(new com.google.common.base.Predicate<Person>() {
                    @Override
                    public boolean apply(Person person) {
                        return person.getAge()>=20;
                    }
                })
                .transform(new Function<Person, Integer>() {
                    @Override
                    public Integer apply(Person person) {
                        return person.getAge();
                    }
                })
                .toList();
        if(!agesPersons.isEmpty()) {
            double sum = 0;
            for (Integer age : agesPersons) {
                sum += age;
            }
            double moyenne = sum / agesPersons.size();
            System.out.println(moyenne);
        }

    }

}
