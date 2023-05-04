package cs1302.genlist;


/**
 * Represents a container for objects of type {@code T} Each container has associated
 * with it a set of properties. Within this documentation, a property that is referred to as
 * <i>set</i> is assumed to refer to some object, and a property that is <i>unset</i> is
 * assumed to contain the value {@code null}. Here is the full list of associated
 * properties:
 * <ul style="padding-top: 1em;">
 * <li>{@code contents}- a reference to an associated object of type {@code T}; and</li>
 * <li>{@code next} - a reference to another {@code Node} object.</li>
 * </ul>
 *
 * <h3>Conditions for {@code contents} Property</h3>
 * The {@code contents} property is not allowed to be <i>unset</i>. This condition is enforced by
 * the container's constructors and associated setter methods.
 *
 * <h3>Conditions for {@code next} Property</h3>
 * The {@code next} property may be <i>set</i> or <i>unset</i>. Users of this container may use
 * verbeage such as "this container does not refer to another container" when this property
 * is unset.
 */
public class Node<T> {

    /** A reference to the contents of this container. */
    private T contents;

    /** A reference to another {@code Node}. */
    private Node next;

    /**
     * Constructs {@code Node} with the {@code contents} property <i>set</i> and the
     * {@code next} property <i>unset</i>.
     *
     * @param contents reference to the associated object
     * @throws NullPointerException if {@code contents} is {@code null}.
     */
    public Node(T contents) {
        set(contents);
    } // Node

    /**
     * Constructs a {@code Node} with the {@code contents} property <i>set</i>
     * and the {@code next} property <i>set</i> or <i>unset</i>.
     *
     * @param contents reference to the associated object
     * @param next reference to the next container
     * @throws NullPointerException if {@code contents} is {@code null}.
     */
    public Node(T contents, Node next) {
        set(contents);
        this.next = next;
    } // Node

    /**
     * Returns the value of the {@code next} property for this container.
     *
     * @return the reference to the next container
     */
    public Node getNext() {
        return next;
    } // getNext

    /**
     * Sets the value of the {@code next} property for this container.
     *
     * @param next a reference to the next container
     */
    public void setNext(Node next) {
        this.next = next;
    } // setNext

    /**
     * Sets the value of the {@code contents} property for this container.
     *
     * @param contents reference to the associated object
     * @throws NullPointerException if {@code contents} is {@code null}.
     */
    public void set(T contents) {
        this.contents = contents;
    } // set

    /**
     * Returns the value of the {@code contents} property for this container.
     *
     * @return the reference to the associated object
     */
    public T get() {
        return contents;
    } // get

} // Node
