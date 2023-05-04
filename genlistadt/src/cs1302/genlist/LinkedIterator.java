package cs1302.genlist;

import java.util.Iterator;
import cs1302.genlist.Node;

/** Class used to implement the Iterator method in {@code LinkedGenList}. */
public class LinkedIterator<T> implements Iterator<T> {
    Node<T> ref = null;
    Node<T> head = null;

    /** Creates a {@code LinkedIterator} object.
        @param first Head {@code Node} of the {@code LinkedGenList}. */
    public LinkedIterator(Node<T> first) {
        head = first;
    } //LinkedIterator

    /** Returns true if current {@code Node} in iteration has a next element.
        @return true If current has a next value. */
    public boolean hasNext() {
        if (head != null && ref.getNext() != null) {
            return true;
        } else if (ref != null) {
            return ref.getNext() != null;
        } //if
        return false;
    } //hasNext

    /** Returns the value of the next {@code Node} in iteration.
        @return holder {@code T} object that is contained within the next {@code Node}. */
    public T next() {
        if (ref == null && head != null) {
            ref = head;
            return ref.get();
        }
        ref = ref.getNext();
        T holder = ref.get();
        return holder;
    } //next

} //LinkedIterator
