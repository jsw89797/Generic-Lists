package cs1302.genlist;

import java.util.function.Predicate;
/** Class used to generate function used to test allMatch and filter.*/

class FiltTest implements Predicate<Integer> {
    /** Implementation of test, takes in integer and returns true if double the integer equals 8.
        @param t Integer being tested in predicate function.
        @return True if integer multiplied by 2 is 8.*/
    public boolean test(Integer t) {
        return t * 2 == 8;
    }
} //filtTest
