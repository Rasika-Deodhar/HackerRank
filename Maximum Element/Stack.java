public class Stack {
    public Node head;
    public Node pointer;

    public void push(Node node) {
        if (head == null) {
            head = node;
            pointer = head;
        } else {
            pointer.next = node;
            pointer = pointer.next;
        }
    }

    public Node pop() {

        if (head == null) {
            return null;
        }

        Node temp = head, returnNode;

        while (temp != null && temp.next != pointer) {
            temp = temp.next;
        }
        if (head == pointer) {
            returnNode = head;
            head = null;
            return returnNode;
        }
        pointer = temp;
        returnNode = pointer.next;
        pointer.next = null;

        return returnNode;
    }

    public int maxElement() {
        int max = 0;
        Node temp = head;

        while (temp != null) {
            if (max < temp.value)
                max = temp.value;
            temp = temp.next;
        }

        return max;
    }
}
