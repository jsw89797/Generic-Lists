package cs1302.genlist;

import java.util.function.BinaryOperator;

/** Class used to create a BinaryOperator function for reduce testing.*/
class RedTest implements BinaryOperator<Integer> {
    /** Implemented apply method takes in two integers and returns product.
        @param t First integer in multiplication.
        @param u Second integer in multiplication.
        @return The product of Integer t and Integer u.*/
    public Integer apply(Integer t, Integer u) {
        return t * u;
    } //apply
} //redTest
