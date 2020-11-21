import java.io.IOException;
import java.util.Scanner;

public class Solution {

    public static class Stack {
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

    public static class Node {
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

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Node temp = null;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(new Node(s.charAt(i)));
            else if (s.charAt(i) == ')') {
                temp = stack.pop();
                if (temp != null && temp.value == '(')
                    continue;
                else
                    return "NO";
            } else if (s.charAt(i) == ']') {
                temp = stack.pop();
                if (temp != null && temp.value == '[')
                    continue;
                else
                    return "NO";
            } else if (s.charAt(i) == '}') {
                temp = stack.pop();
                if (temp != null && temp.value == '{')
                    continue;
                else
                    return "NO";
            } else
                return "NO";
        }
        if (stack.head != null)
            return "NO";
        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);
    static Stack stack = new Stack();

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            System.out.println(isBalanced(s));
            stack.head = null;
        }

        scanner.close();
    }
}
