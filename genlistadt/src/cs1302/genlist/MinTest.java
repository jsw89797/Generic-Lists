package cs1302.genlist;

import java.util.Comparator;
/** Class used to create Comparator object that tests min.*/

class MinTest implements Comparator<Integer> {
    /** Implementation of compare method, returns 0 if integers are equal,
        1 if t > u, and -1 if u > t.
        @param t First integer being compared.
        @param u Second ineger being compared.
        @return Int value indicating which Integer is greater.*/

    public int compare(Integer t, Integer u) {
        if (t > u) {
            return 1;
        } else if (u > t) {
            return -1;
        }
        return 0;
    } //compare
} //mintest
