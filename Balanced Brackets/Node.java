public class Node {
    char value;
    Node next;

    public void addNode(char value) {
        this.value = value;
        this.next = null;
    }

    public Node(char value) {
        this.value = value;
        this.next = null;
    }
}
