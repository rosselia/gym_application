import java.util.ArrayList;

public class LinkedList<T> {
    Node head;
    private int size;

    public LinkedList<T> insert(LinkedList<T> list, T data) {

        Node newNode = new Node(data);

        if (list.head == null) {
            list.head = newNode;
        } else {
            Node temp = list.head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }
        size++;
        return list;
    }

    public void printList(LinkedList<T> list) {
        Node printNode = list.head;

        while (printNode != null) {
            System.out.println(printNode.data);
            printNode = printNode.next;
        }
    }

    public LinkedList<T> deleteByKey(LinkedList<T> list, T key) {
        if (list.head.data.equals(key) && list.head != null) {
            list.head = list.head.next;
        } else {
            Node temp = list.head;
            Node prevNode = temp;

            while (temp != null && !temp.data.equals(key)) {
                prevNode = temp;
                temp = temp.next;
            }

            prevNode.next = temp.next;
        }
        size--;
        return list;
    }

    public LinkedList<T> deleteAtPosition(LinkedList<T> list, int index) {
        Node currNode = list.head, prev = null;

        if (index == 0 && currNode != null) {
            list.head = currNode.next;

            System.out.println(index + " position element deleted");

            return list;
        }

        int counter = 0;

        while (currNode != null) {

            if (counter == index) {
                prev.next = currNode.next;

                System.out.println(
                        index + " position element deleted");
                break;
            } else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }

        if (currNode == null) {
            System.out.println(
                    index + " position element not found");
        }
        size--;
        return list;
    }

    public Node<T> getNode(T data) {
        return new Node(data);
    }

    public Node<T> insertPos(Node<T> headNode, int position, T data) {
        position++;
        Node head = headNode;
        if (position < 1)
            System.out.print("Invalid position");

        if (position == 1) {
            Node newNode = new Node(data);
            newNode.next = headNode;
            head = newNode;
        } else {
            while (position-- != 0) {
                if (position == 1) {
                    Node newNode = getNode(data);

                    newNode.next = headNode.next;

                    headNode.next = newNode;
                    break;
                }
                headNode = headNode.next;
            }
            if (position != 1)
                System.out.print("Position out of range");
        }
        size++;
        return head;
    }

    public int size() {
        return size;
    }

    public LinkedList<T> merge(LinkedList<T> list1, LinkedList<T> list2) {
        Node head1 = list1.head;
        Node head2 = list2.head;
        LinkedList<T> result = new LinkedList<>();

        while (head1 != null) {
            result.insert(result, (T) head1.data);
            head1 = head1.next;
        }

        while (head2 != null) {
            result.insert(result, (T) head2.data);
            head2 = head2.next;
        }

        return result;
    }

    public void sortList() {
        Node<T> current = head, index = null;

        T temp;

        if (head == null) {
            return;
        } else {
            while (current != null) {
                index = current.next;

                while (index != null) {
                    if ((Integer) current.data < (Integer) index.data) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }

                    index = index.next;
                }
                current = current.next;
            }
        }
    }

    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public double max(LinkedList<T> list) {
        double max = (double) list.head.data;

        Node tempHead = list.head;
        while (tempHead != null) {
            if ((Double)tempHead.data > max)
                max = (double) tempHead.data;
            tempHead = tempHead.next;
        }

        return max;
    }

    public double min(LinkedList<T> list) {
        double min = (double) list.head.data;

        Node tempHead = list.head;
        while (tempHead != null) {
            if ((Double)tempHead.data < min)
                min = (double) tempHead.data;
            tempHead = tempHead.next;
        }

        return min;
    }

    public static LinkedList doubleToInt(LinkedList<Double> list) {
        LinkedList<Integer> intList = new LinkedList<>();

        ArrayList<Double> temp = list.linkedToArrayList(list);
        ArrayList<Integer> temp2 = new ArrayList<>();
        for (Double i: temp)
            temp2.add(i.intValue());

        for (int j : temp2)
            intList.insert(intList, j);

        intList = arrayToLinked(temp2);

        return intList;
    }

    public static LinkedList<Integer> arrayToLinked(ArrayList<Integer> list) {
        LinkedList<Integer> temp = new LinkedList<>();

        for (int i: list)
            temp.insert(temp, i);

        return temp;
    }

    // this method is here just for database
    public ArrayList<T> linkedToArrayList(LinkedList<T> list) {
        ArrayList<T> arrayList = new ArrayList<>();

        Node tempHead = list.head;
        while (tempHead != null) {
            arrayList.add((T) tempHead.data);
            tempHead = tempHead.next;
        }

        return arrayList;
    }
}
