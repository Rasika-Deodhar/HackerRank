import java.io.IOException;
import java.util.Scanner;

public class Solution {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node) throws IOException {
        while (node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }

    // Complete the sortedInsert function below.

    /*
     * For your reference:
     *
     * DoublyLinkedListNode { int data; DoublyLinkedListNode next;
     * DoublyLinkedListNode prev; }
     *
     */
    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {

        if (head == null) {
            return new DoublyLinkedListNode(data);
        }

        DoublyLinkedListNode temp = null;
        DoublyLinkedListNode _head = head;

        if (head.data >= data) {
            head.prev = new DoublyLinkedListNode(data);
            head.prev.next = head;
            return head.prev;
        }

        while (head.data <= data && head.next != null) {
            head = head.next;
        }
        if (head.next == null && head.data <= data) {
            head.next = new DoublyLinkedListNode(data);
            head.next.prev = head;
            return _head;
        }
        temp = head.prev;
        temp.next = new DoublyLinkedListNode(data);
        temp.next.prev = temp;
        temp.next.next = head;
        head.prev = temp.next;

        return _head;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1);
        }

        scanner.close();
    }
}
