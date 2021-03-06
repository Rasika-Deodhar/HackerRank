import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    // private static final Scanner scanner = new Scanner(System.in);

    // public static void main(String[] args) {
    // int n = scanner.nextInt();

    // Stack stack = new Stack();

    // while (n-- > 0) {
    // int type = scanner.nextInt();
    // if (type == 1) {
    // int digit = scanner.nextInt();
    // stack.push(new Node(digit));
    // } else if (type == 2) {
    // stack.pop();
    // } else {
    // System.out.println(stack.maxElement());
    // }
    // }
    // }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack stack;

    public class Node {
        int value;
        Node next;

        public Node addNode(int value) {
            this.value = value;
            this.next = null;
            return this;
        }

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static class Stack {
        public Node head;
        public Node pointer;
        public int max = 0;

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
            Node temp = head;

            while (temp != null) {
                if (max < temp.value)
                    max = temp.value;
                temp = temp.next;
            }

            return max;
        }
    }

    public Node addNodeCaller(int digit) {
        Node node = new Node(digit);
        return node;
    }

    public void pushCaller(Node node) {
        stack.push(node);
    }

    public Node popCaller() {
        return stack.pop();
    }

    public int maxElementCaller() {
        return stack.maxElement();
    }

    public Stack createStack() {
        return new Stack();
    }

    public boolean isEmpty() {
        return stack.head == null ? true : false;
    }

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        // int n = scanner.nextInt();
        String n_ = br.readLine();
        String[] strs_ = n_.trim().split("\\s+");
        int n = Integer.parseInt(strs_[0]);
        int max = 0;
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Solution s = new Solution();
        stack = s.createStack();

        List<Integer> res = new ArrayList<>();

        while (n-- > 0) {
            String lines = br.readLine();
            String[] strs = lines.trim().split("\\s+");
            int type = Integer.parseInt(strs[0]);
            if (type == 1) {
                int digit = Integer.parseInt(strs[1]);
                Node node = s.addNodeCaller(digit);
                s.pushCaller(node);
                max = Math.max(max, digit);
            } else if (type == 2) {
                s.popCaller();
                if (s.isEmpty())
                    max = 0;
                else
                    max = s.maxElementCaller();
            } else {
                if (!s.isEmpty())
                    System.out.println(max);
                // System.out.println(max);
                // res.add(s.maxElementCaller());
            }
        }

        for (Integer integer : res) {
            System.out.println(integer);
        }

    }
}