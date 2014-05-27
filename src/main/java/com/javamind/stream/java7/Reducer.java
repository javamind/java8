package com.javamind.stream.java7;

/**
 * Mapper on a property (P) from an object (O)
 * @author EHRET_G
 */
public interface Reducer<R> {
    R reduce(R r1, R r2);
}
