package com.javamind.stream.java7;

/**
 * Mapper on a property (P) from an object (O)
 * @author EHRET_G
 */
@FunctionalInterface
public interface Mapper<O, P> {
    P map(O o);
}
