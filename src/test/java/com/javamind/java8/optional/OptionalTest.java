package com.javamind.java8.optional;

import com.javamind.model.PersonRepository;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * {@link }
 *
 * @author EHRET_G
 */
public class OptionalTest {

    private PersonRepository personRepository = new PersonRepository();

    @Test
    public void shouldNotFindPerson(){
        assertThat(personRepository.getWinnerByName("Wendy")).isNull();
    }

    @Test
    public void shouldFindPerson(){
        assertThat(personRepository.getWinnerByName("Mathilde").getAge()).isEqualTo(15);
    }

    @Test
    public void shouldNotFindPersonWithOptional(){
        assertThat(personRepository.getWinnerByName3("Wendy")).isEqualTo(Optional.empty());
       }

    @Test
    public void shouldFindPersonOptional(){
        assertThat(personRepository.getWinnerByName3("Mathilde").get().getAge()).isEqualTo(15);

    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowException(){
        Optional.empty().get();
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldFindNull(){
        assertThat(Optional.of(null).get()).isNull();
        assertThat(Optional.of("toto").get()).isEqualTo("toto");
    }
}
