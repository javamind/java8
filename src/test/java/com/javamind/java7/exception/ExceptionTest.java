package com.javamind.java7.exception;

import com.javamind.domain.Person;
import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Catch de plusieurs exceptions
 * http://docs.oracle.com/javase/7/docs/technotes/guides/language/catch-multiple.html
 */
public class ExceptionTest {


    @Test
    public void testMultiCatch(){
        try {
            //Un bout de code qui ne sert à rien mais qui peux générer deux exceptions
            Person.class.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e) {

        }
    }
}
