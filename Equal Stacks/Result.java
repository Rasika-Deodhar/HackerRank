import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY h1
     * 2. INTEGER_ARRAY h2
     * 3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here

        System.out.println("The 3 stack are -");
        for (int i = 0; i < h1.size(); i++) {
            System.out.print(h1.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < h2.size(); i++) {
            System.out.print(h2.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < h3.size(); i++) {
            System.out.print(h3.get(i) + " ");
        }

        // Cumulative Sum of Height STack -> Ref ->
        // https://www.youtube.com/watch?v=zZhnb_8d6CU

        int h1_height = h1.stream().mapToInt(a -> a).sum();
        int h2_height = h2.stream().mapToInt(a -> a).sum();
        int h3_height = h3.stream().mapToInt(a -> a).sum();

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        fillSumStacks(s1, h1, s2, h2, s3, h3);

        System.out.println("The cumulative sum of 3 stacks are -");
        for (int i = 0; i < s1.size(); i++) {
            System.out.print(s1.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < s2.size(); i++) {
            System.out.print(s2.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < s3.size(); i++) {
            System.out.print(s3.get(i) + " ");
        }

        while (!s1.isEmpty() && !s2.isEmpty() && !s3.isEmpty()) {
            int s1_height = s1.peek();
            int s2_height = s2.peek();
            int s3_height = s3.peek();

            if (s1_height == s2_height && s2_height == s3_height && s1_height == s3_height) {
                return s1_height;
            }

            if (s1_height > s2_height && s1_height > s3_height) {
                s1.pop();
            } else if (s2_height > s1_height && s2_height > s3_height) {
                s2.pop();
            } else if (s3_height > s2_height && s3_height > s1_height) {
                s3.pop();
            }
        }

        return 0;

    }

    private static void fillSumStacks(Stack<Integer> s1, List<Integer> h1, Stack<Integer> s2, List<Integer> h2,
            Stack<Integer> s3, List<Integer> h3) {
        fillStack(s1, h1);
        fillStack(s2, h2);
        fillStack(s3, h3);

    }

    private static void fillStack(Stack<Integer> s, List<Integer> h) {
        Collections.reverse(h);
        Integer sum = 0;

        for (int i = 0; i < h.size(); i++) {
            sum += h.get(i);
            s.push(sum);
        }
    }

}
