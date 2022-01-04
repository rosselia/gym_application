public class Node<T> {
    T data;
    Node next;
    Node previous;

    Node(T d) {
        this.data = d;
        this.next = null;
        this.previous = null;
    }
}
