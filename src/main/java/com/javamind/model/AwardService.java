package com.javamind.model;

import com.javamind.domain.Person;

import java.util.Optional;

/**
 * {@link }
 *
 * @author EHRET_G
 */
public class AwardService {
    private PersonRepository personRepository = new PersonRepository();

    /**
     * Without optional we can have a NPE
     * @param name
     * @return
     */
    public void sendMailToWinner(String name){
        Person person = personRepository.getWinnerByName(name);
        if(person!=null){
            sendMail(person.getMail(), "You win...");
        }
    }

    /**
     * With Optional it's better
     * @param name
     * @return
     */
    public void sendMailToWinner2(String name){
        Optional<Person> person = personRepository.getWinnerByName2(name);
        if(person.isPresent()){
            sendMail(person.get().getMail(), "You win...");
        }
    }

    /**
     * With Optional it's better
     * @param name
     * @return
     */
    public void sendMailToWinner3(String name){
        personRepository.getWinnerByName2(name).ifPresent(p -> sendMail(p.getMail(), "You win..."));
    }


    public void sendMail(String recipient, String object){

    }
}
