package com.javamind.heritage;

/**
 * Created by ehret_g on 27/05/14.
 */
public interface B {
    default public String a(){
        return "b";
    }
}
