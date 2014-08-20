package com.javamind.java8.optional;

import com.javamind.domain.Person;
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

    @Test
    public void shouldFindNull(){
        assertThat(Optional.ofNullable(null).isPresent()).isEqualTo(false);
        assertThat(Optional.of("toto").get()).isEqualTo("toto");

        assertThat(personRepository.getWinnerByName3("Wendy")
                .orElse(new Person().setName("anonymous")).getName())
                .isEqualTo("anonymous");

        assertThat(personRepository.getWinnerByName3("Wendy")
                .orElseGet(() -> personRepository.getWinnerByName3("Mathilde").get()).getName())
                .isEqualTo("Mathilde");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldthrowExceptionWhenElementNotFound(){
        personRepository.getWinnerByName3("Wendy").orElseThrow(IllegalArgumentException::new);
    }


    @Test
    public void shouldTransformResult(){

        assertThat(Optional.of("toto").map( p -> p.toUpperCase()).get()).isEqualTo("TOTO");
        assertThat(Optional.of("toto").filter( p -> p.equals("titi"))).isEqualTo(Optional.empty());

    }
}
