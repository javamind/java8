package com.javamind.java7.switchstring;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * En java 7 on peut utiliser des String dans les switchs
 */
@RunWith(Parameterized.class)
public class SwitchTest {

    private String myValue;

    public SwitchTest(String myValue) {
        this.myValue = myValue;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"a"}, {"ab"}, {"abc"}});
    }

    @Test
    public void switchJava7ShouldAcceptString()  {
        switch (myValue){
            case "a":
                Assertions.assertThat(myValue).isEqualTo("a");
                break;
            case "ab":
                Assertions.assertThat(myValue).isEqualTo("ab");
                break;
            case "abc":
                Assertions.assertThat(myValue).isEqualTo("abc");
                break;
            default:
                Assertions.fail("devrait etre traite");
        }

    }


}
