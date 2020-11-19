import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();

        Stack stack = new Stack();

        while (n-- > 0) {
            int type = scanner.nextInt();
            if (type == 1) {
                int digit = scanner.nextInt();
                stack.push(new Node(digit));
            } else if (type == 2) {
                stack.pop();
            } else {
                System.out.println(stack.maxElement());
            }
        }
    }
}