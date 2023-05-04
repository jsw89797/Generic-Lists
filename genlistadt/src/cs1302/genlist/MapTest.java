package cs1302.genlist;

import java.util.function.Function;

/** Class used to create a Function object for map testing.*/
class MapTest implements Function<Double, Long> {
    /** Implementation of apply method. Rounds doubles into Long elements.
        @param d Double value being rounded.
        @return Rounded doubles as Longs. */
    public Long apply(Double d) {
        return Math.round(d);
    } //apply
} //mapTest
