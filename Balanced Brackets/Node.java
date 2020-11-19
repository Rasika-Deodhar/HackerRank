public class Node {
    int value;
    Node next;

    public void addNode(int value) {
        this.value = value;
        this.next = null;
    }

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}
