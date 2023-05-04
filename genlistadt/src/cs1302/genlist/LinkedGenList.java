package cs1302.genlist;

import cs1302.genlistadt.GenList;
import cs1302.genlist.Node;
import java.util.function.Function;
import java.util.Comparator;
import java.util.function.Predicate;
import java.util.function.BinaryOperator;
import java.util.function.IntFunction;
import java.util.Iterator;
import cs1302.genlist.LinkedIterator;

/** This is the {@code LinkedGenList} class, it implements
    the {@code GenList} interface using node objects. */

public class LinkedGenList<T> implements GenList<T>, Iterable<T> {
    private Node<T> head;
    private int size;
    private T initialCont = null;

/** Constructs new {@code LinkedGenList} with default values. */
    public LinkedGenList() {
        size = 0;
        head = new Node(initialCont);
    } //LinkedGenList

    /**
       Finds the node at specified index.
       @param index Specified index of node wanting to be found.
       @return copy Node at specified index.
    */
    public Node<T> getNodeAtIndex(int index) {
        Node<T> copy;
        copy = head;
        for (int i = 0; i < index; i++) {
            copy = copy.getNext();
        } //for
        return copy;
    } //getNodeAtIndex

/** Creates a copy {@code GenList}.
    @param <U> Type of specified {@code GenList}.
    @param other The {@code GenList} being copied.
*/

    public <U extends T> LinkedGenList(GenList<U> other) {
        size = 0;
        add(other);
    } //LinkedGenList

    /**
       This adds a {@code T} value to the end of the {@code GenList}.
       @param obj Specified T value wanting to add.
       @return True if element is added.
    */

    public boolean add(T obj) {
        switch (size()) {
        case 0:
            head.set(obj);
            size++;
            return true;
        case 1:
            head.setNext(new Node(obj));
            size++;
            return true;
        }
        Node<T> ref = head;
        for (int i = 0; i < size() - 1; i++) {
            ref = ref.getNext();
        } //for
        ref.setNext(new Node(obj));
        size++;
        return true;
    } //add

    /**
       This adds a {@code GenList} value to the end of the {@code GenList}.
       @param list Specified {@code GenList} value wanting to add.
       @param <U> Type of Specified {@code GenList}.
       @return True if element is added.
    */

    public <U extends T> boolean add(GenList<U> list) {
        Node<T> ref = head;
        LinkedGenList<T> copy = new LinkedGenList();
        for (int i = 0; i < list.size(); i++) {
            copy.add(list.get(i));
        } //for
        if (size() > 0) {
            ref = getNodeAtIndex(size() - 1);
            for (int i = 0; i < list.size(); i++) {
                ref.setNext(new Node(copy.get(i)));
                ref = ref.getNext();
                size++;
            }
            return true;
        }
        head = new Node(list.get(0));
        size++;
        ref = head;
        for (int i = 1; i <= copy.size(); i++) {
            ref.setNext(new Node(copy.get(i)));
            ref = ref.getNext();
            size++;
        } //for
        size = size - 1;
        return true;
    } //add

    /**
       This adds a {@code T} value to a specified {@code index} in the {@code GenList}.
       @param index Specified index, where {@code T} value is desired.
       @param obj Specified T value wanting to add.
       @return True if element is added.
    */
    public boolean add(int index, T obj) {
        Node<T> ref = null;
        LinkedGenList<T> copy = new LinkedGenList();
        this.size++;
        if (index == 0 && size() == 0) {
            head = new Node(obj);
            return true;
        } else if (index == 0) {
            for (int i = 0; i < size(); i++) {
                copy.add(get(i));
            }
            head = new Node(obj);
            add(copy);
            return true;
        } //if
        ref = getNodeAtIndex(index - 1);
        for (int i = index; i < size(); i++) {
            copy.add(get(i));
        } //for
        ref.setNext(new Node(obj));
        this.add(copy);
        return true;
    } //add

    /**
       This adds a {@code GenList} object to a specified {@code index} in the {@code GenList}.
       @param index Specified index, where {@code GenList} value is desired.
       @param list Specified {@code GenList} value wanting to add.
       @param <U> Type of specified {@code GenList}.
       @return True if elements are added.
    */
    public <U extends T> boolean add(int index, GenList<U> list) {
        Node<T> ref = null;
        LinkedGenList<T> copy = new LinkedGenList();
        if (index == 0 && size() == 0) {
            add(list);
            this.size = list.size();
            return true;
        } else if (index == 0) {
            for (int i = 0; i < size(); i++) {
                copy.add(get(i));
            } //for
            this.size = this.size() + copy.size();
            clear();
            add(list);
            add(copy);
            return true;
        } //if
        for (int i = 0; i < list.size(); i++) {
            add(index, list.get(i));
            this.size++;
        } //for
        return true;
    } //add

    /** Returns true if all objects in {@code GenList} abide by given predicate.
        @param p Specified {@code Predicate} function to be applied.
        @return true If all elements match with specified {@code Predicate}.*/
    public boolean allMatch(Predicate<T> p) {
        Node<T> ref = head;
        for (int i = 0; i < size(); i++) {
            if (!(p.test(ref.get()))) {
                return false;
            } //if
            ref = ref.getNext();
        } //for
        return true;
    } //allMatch

    /** Returns true if atleast one object in {@code GenList} abide by given predicate.
        @param p Specified {@code Predicate} function to be applied.
        @return true If any of the elements match with specified {@code Predicate}.*/
    public boolean anyMatch(Predicate<T> p) {
        Node<T> ref = head;
        for (int i = 0; i < size(); i++) {
            if (p.test(ref.get())) {
                return true;
            } //if
            ref = ref.getNext();
        } //for
        return false;
    } //anyMatch

    /** Clears list in the calling {@code LinkedGenList} object. */
    public void clear() {
        this.size = 0;
        this.head = null;
    } //clear

    /**
       Checks to see if the specified {@code T} is within the list (case sensitive).
       @param o Specified {@code T} value user wants to search list for.
       @return {@code boolean} indicating whether the value is within the list.
    */
    public boolean contains(T o) {
        Node<T> ref = head;
        for (int i = 0; i < size() - 1; i++) {
            if (o.equals(ref.get())) {
                return true;
            } //if
            ref = ref.getNext();
        } //for
        return false;
    } //contains

    /**
       Creates a new {@code LinkedGenList} object of calling {@code LinkedGenList}
       without repeating elements.
       @return New {@code LinkedGenList} with no repeating elements.
    */
    public GenList<T> distinct() {
        Node<T> ref = head;
        LinkedGenList<T> copy = new LinkedGenList();
        boolean finished = false;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < size(); j++) {
                if (!(ref.get().equals(this.get(j))) && j == i + 1) {
                    copy.add(ref.get());
                } //if
            } //for
            ref = ref.getNext();
        }
        return copy;

    } //distinct

    /** Removes elements in {@code GenList} that do not abide by given {@code Predicate} function.
        @param p Specified {@code Predicate} function to be applied.
        @return copy Filtered out {@code GenList}.*/
    public GenList<T> filter(Predicate<T> p) {
        LinkedGenList<T> copy = new LinkedGenList();
        for (int i = 0; i < size(); i++) {
            if (p.test(this.get(i))) {
                copy.add(this.get(i));
            } //if
        } //for
        return copy;
    } //filter

    /**
       Returns the value of the list element at specified {@code index}.
       @param index Specified postion of desired list element.
       @return value of desired list element.
    */
    public T get(int index) {
        Node<T> ref = head;
        if (index == 0) {
            return head.get();
        } //if
        for (int i = 0; i < index; i++) {
            if (ref.getNext() != null) {
                ref = ref.getNext();
            }
        }
        return ref.get();
    } //get

    /**
       Finds the index of the node containing specified T object.
       @param obj Specified {@code T} to be found.
       @return index of the node containing the specified object.
    */
    public int indexOf(T obj) {
        for (int i = 0; i < size(); i++) {
            if (obj.equals(get(i))) {
                return i;
            } //if
        } //for
        return -1;
    } //indexOf

    /**
       Returns whether or not the calling {@code GenList} is empty.
       @return True if {@code GenList} is empty.
    */
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    } //isEmpty

    /** Creates a new Iterator object using storage of {@code LinkedGenList}.
     @return New {@code Iterator} object from list.*/
    public Iterator<T> iterator() {
        return new LinkedIterator(head);
    } //iterator

    /**
       Creates a {@code String} value containing all elements of the {@code GenList}.
       @return holder {@code String} value containing all elements in calling {@code GenList}.
    */

    public String makeString() {
        String holder = "";
        if (size() == 0) {
            return holder;
        } //if
        Node<T> ref = head;
        for (int i = 0; i < size(); i++) {
            holder += getNodeAtIndex(i).get().toString();
            if (i < size() - 1) {
                ref = ref.getNext();
            } //if
        } //for
        return holder;
    } //makeString

    /**
       Creates a {@code String} value containing all elements of the {@code GenList},
       with desired separator value between each element.
       @param sep Separating value between each list element in newly made {@code String} object.
       @return holder {@code String} value containing all elements in calling {@code GenList}.
    */
    public String makeString(String sep) {
        String holder = "";
        if (size() == 0) {
            return holder;
        } //if
        Node<T> ref = head;
        for (int i = 0; i < size(); i++) {
            holder += ref.get().toString();
            if (i < size() - 1) {
                holder += sep;
            } //if
            ref = ref.getNext();
        } //for
        return holder;
    } //makeString


    /**
       Creates a {@code String} value containing all elements of the {@code GenList},
       with desired separator value between each element, as well as a specified {@code start}
       and {@code end} value.
       @param start Starting value of the newly made {@code String} object.
       @param sep Separating value between each list element in newly made {@code String} object.
       @param end Ending value of the newly made {@code String} object
       @return holder {@code String} value containing all elements in calling {@code GenList}.
    */
    public String makeString(String start, String sep, String end) {
        String holder = "";
        if (size() == 0) {
            return holder;
        } //if
        holder += start;
        Node<T> ref = head;
        for (int i = 0; i < size(); i++) {
            holder += ref.get().toString();
            if (i < size() - 1) {
                holder += sep;
            }
            ref = ref.getNext();
        } //for
        holder += end;
        return holder;
    } //makeString

    /** Applies a {@code Function} to each {@code T} object in {@code LinkedGenList}.
        It then returns a new {@code GenList} with newly mapped objects.
        @param f Specified {@code Function} applied to each object.
        @param <R> Result type of specified {@code Function}
        @return copy Newly mapped {@code GenList} object.
    */
    public <R>GenList<R> map(Function<T,R> f) {
        LinkedGenList<R> copy = new LinkedGenList();
        if (size() == 1) {
            copy.add(f.apply(this.get(0)));
            return copy;
        } //if
        for (int i = 0; i < size(); i++) {
            copy.add(f.apply(this.get(i)));
        } //for
        return copy;
    } //map

    /** Returns the maximum {@code T} object specified by using the given {@code Comparator}.
        @param c Specified {@code Comparator} to be used.
        @return ref.get() Value of current ref {@code Node}.*/
    public T max(Comparator<T> c) {
        Node<T> ref = head;
        if (size() == 1) {
            return this.get(0);
        } //if
        for (int i = 1; i < size(); i++) {
            if (c.compare(this.get(i), ref.get()) == 1) {
                ref = getNodeAtIndex(i);
            }
        } //for
        return ref.get();
    } //max

    /** Returns the minimum {@code T} object specified by using the given {@code Comparator}.
        @param c Specified {@code Comparator} to be used.
        @return ref.get() Value of current ref {@code Node}.*/
    public T min(Comparator<T> c) {
        Node<T> ref = head;
        if (size() == 1) {
            return this.get(0);
        } //if
        for (int i = 0; i < size(); i++) {
            if (c.compare(this.get(i), ref.get()) == -1) {
                ref = getNodeAtIndex(i);
            } //if
        } //for
        return ref.get();
    } //min

    /** Returns a new {@code T} object created using given {@code BinaryOperator} function.
        @param start Object applied in reducing with reduced {@code GenList}.
        @param f Specified {@code Binary} applied to reduce.
        @return ref Reduced {@code T object}. */
    public T reduce(T start, BinaryOperator<T> f) {
        T ref = head.get();
        for (int i = 1; i < size(); i++) {
            ref = f.apply(ref, this.get(i));
        } //for
        ref = f.apply(start,ref);
        return ref;
    } //reduce

    /**
       Removes {@code T} value at specified {@code index}.
       @param index Specified index that is desired to be removed.
       @return The removed {@code T} value.
    */
    public T remove(int index) {
        T holder = null;
        if (index == 0) {
            holder = head.get();
            head = head.getNext();
            size--;
            return holder;
        } else if (index == size() - 1) {
            holder = getNodeAtIndex(index).get();
            getNodeAtIndex(index - 1).setNext(null);
            size--;
            return holder;
        }
        Node<T> ref = getNodeAtIndex(index + 1);
        holder = getNodeAtIndex(index).get();
        getNodeAtIndex(index - 1).setNext(ref);
        size--;
        return holder;
    } //remove

    /**
       Returns a new {@code LinkedGenList} object which is the reverse of
       calling {@code LinkedGenList}.
       @return aList {@code LinkedGenList} with elements listed in reverse.
    */

    public GenList<T> reverse() {
        LinkedGenList<T> copy = new LinkedGenList();
        for (int i = size() - 1; i < 0; i--) {
            copy.add(getNodeAtIndex(i).get());
        } //for
        return copy;
    } //reverse

    /**
       Sets the value at the specified {@code index} to the specified
       {@code T} value.
       @param index The index where {@code String} value is desired.
       @param obj The specified {@code T} value to be set.
       @return holder Replaced {@code T} value.
    */
    public T set(int index, T obj) {
        T holder = null;
        Node<T> ref = null;
        if (index == size() - 1) {
            holder = getNodeAtIndex(index).get();
            getNodeAtIndex(index - 1).setNext(new Node(obj));
            return holder;
        } //if
        if (index < size() - 1) {
            if (index == 0) {
                holder = head.get();
                head = new Node(obj);
                head.setNext(ref);
                return holder;
            } //if
            ref = getNodeAtIndex(index + 1);
            holder = getNodeAtIndex(index).get();
            getNodeAtIndex(index - 1).setNext(new Node(obj));
            getNodeAtIndex(index).setNext(ref);
        } //if
        return holder;
    } //set

    /**
       This method returns the number of elements in the calling {@code LinkedGenList}.
       @return size The number of elements in the list.
    */
    public int size() {
        return this.size;
    } //size

    /**
       This method creates a new {@code LinkedGenList} by removing values that
       are not in between the two ranges {@code fromIndex} and {@code toIndex}.
       @param fromIndex Starting index
       @param toIndex Ending index
       @return aList newly made {@code LinkedGenList} value.
    */
    public GenList<T> splice(int fromIndex, int toIndex) {
        Node<T> ref = null;
        LinkedGenList<T> copy = new LinkedGenList();
        for (int i = fromIndex; i < toIndex; i++) {
            ref = getNodeAtIndex(i);
            copy.add(ref.get());
        } //for
        return copy;
    } //splce

    /**
       Returns values in a {@code GenList} object inside an {@code T} array.
       @param gen {@code IntFunction} used to generate array of T objects.
       @return holder Array created from {@code GenList} values.
    */
    public T[] toArray(IntFunction<T[]> gen) {
        T[] array = gen.apply(this.size());
        for (int i = 0; i < this.size(); i++) {
            array[i] = get(i);
        } //for
        return array;
    } //toArray
} //LinkedGenList<T>
