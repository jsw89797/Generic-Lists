package cs1302.genlist;

import cs1302.genlist.LinkedGenList;
import java.lang.Math;
import java.util.function.Function;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import cs1302.genlistadt.GenList;
import java.util.Comparator;
import cs1302.genlist.MapTest;
import cs1302.genlist.MinTest;
import cs1302.genlist.RedTest;
import cs1302.genlist.FiltTest;
/** Class used to test a sample of the methods contained in {@code LinkedGenList}. */

public class LinkedGenListTest {

    /** Main method used to run tests.
        @param args Command line input */
    public static void main(String[] args) {
        demoMap();
        System.out.print("\n");
        demoReduce();
        System.out.print("\n");
        demoFilter();
        System.out.print("\n");
        demoMin();
        System.out.print("\n");
        demoAllMatch();
    } //main

    /** Method used to test map function in {@code LinkedGenList}. */
    public static void demoMap() {
        System.out.println("This is the demoMap test!");
        LinkedGenList<Double> dList = new LinkedGenList();
        dList.add(0.5);
        dList.add(1.3);
        dList.add(2.7);
        dList.add(3.8);
        System.out.println("List before map: " + dList.makeString("START: ", ", ", " END"));
        System.out.println("Predicate function uses math.round to round doubles to rounded Longs!");
        System.out.println("Therefore the expected output should be: START: 1, 1, 3, 4");
        Function<Double, Long> f =  new MapTest();
        System.out.println("List after map: " + dList.map(f).makeString("START: ", ", ", " END"));
    }

    /** Method used to test reduce function in {@code LinkedGenList}. */
    public static void demoReduce() {
        System.out.println("This is the demoReduce test!");
        LinkedGenList<Integer> intList = new LinkedGenList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println("List under reduction: " + intList.makeString("START: ", ", ", " END"));
        System.out.println("Reducing function takes in two integers and returns the product.");
        System.out.println("Expected output should be: 12");
        BinaryOperator<Integer> mult = new RedTest();
        int result = intList.reduce(2,mult);
        System.out.println("Result: " + result);
    }

    /** Method used to test filter function in {@code LinkedGenList}. */
    public static void demoFilter() {
        System.out.println("This is the demoFilter test!");
        LinkedGenList<Integer> intList = new LinkedGenList();
        intList.add(4);
        intList.add(2);
        intList.add(3);
        System.out.println("List being filtered: " + intList.makeString("START: ", ", ", " END"));
        System.out.println("Predicate function returns true if number * 2 equals 8!");
        System.out.println("Expected List should be: 4");
        Predicate<Integer> p = new FiltTest();
        GenList<Integer> intList2 = new LinkedGenList();
        intList2 = intList.filter(p);
        System.out.println("Newly filtered list: " + intList2.makeString());
    } //demoFilter

    /** Method used to test min function in {@code LinkedGenList}. */
    public static void demoMin() {
        System.out.println("This is the demoMin test!");
        LinkedGenList<Integer> intList = new LinkedGenList();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println("List being tested: " + intList.makeString("START: ", ", ", " END"));
        System.out.println("Function compares list and returns the minimum!");
        System.out.println("Expected output should be: 1");
        Comparator<Integer> c = new MinTest();
        System.out.println("Output: " + intList.min(c));
    } //demoMin

    /** Method used to test allMatch function in {@code LinkedGenList}. */
    public static void demoAllMatch() {
        System.out.println("This is the demoAllMatch test!");
        System.out.println("Uses two lists, one that will produce a true result the other false!");
        LinkedGenList<Integer> intList = new LinkedGenList();
        intList.add(4);
        intList.add(4);
        intList.add(4);
        System.out.println("List that should return true: " +
                           intList.makeString("START: ", ", ", " END"));
        LinkedGenList<Integer> intList2 = new LinkedGenList();
        intList2.add(4);
        intList2.add(4);
        intList2.add(2);
        System.out.println("List that should return false: " +
                           intList2.makeString("START: ", ", ", " END"));
        Predicate<Integer> p = new FiltTest();
        System.out.println("Result of first list: " + intList.allMatch(p));
        System.out.println("Result of second list: " + intList2.allMatch(p));
    } //demoAllMatch
} //LinkedGenListTest
