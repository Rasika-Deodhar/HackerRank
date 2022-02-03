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

        int h1_height = h1.stream().mapToInt(a -> a).sum();
        int h2_height = h2.stream().mapToInt(a -> a).sum();
        int h3_height = h3.stream().mapToInt(a -> a).sum();

        // Check the total height of all 3 stacks
        // If equal then return height
        // Else
        //// If first 2 are same ->
        //// If A,B > C -> remove from A and B
        //// Else remove from C

        //// If first and third are same ->
        //// If A,C > B -> Remove from A and C
        //// Else remove from B

        //// If second and third are same ->
        //// If B,C > A -> Remove from B and C
        //// Else remove from A

        if (h1_height == h2_height && h2_height == h3_height) {
            return h1_height;
        }
        if (h1_height == 0 || h2_height == 0 || h3_height == 0) {
            return 0;
        }

        do {
            if (h1_height == h2_height) {
                if (h1_height > h3_height) {
                    if ((h1_height - h1.get(0) == h2_height - h2.get(0)) && (h1_height - h1.get(0) == h3_height)) {
                        return h3_height;
                    }
                    h1_height -= h1.get(0);
                    h1.remove(0);
                    h2_height -= h2.get(0);
                    h2.remove(0);
                } else {
                    h3_height -= h3.get(0);
                    h3.remove(0);
                }
            } else if (h1_height == h3_height) {
                if (h1_height > h2_height) {
                    if ((h1_height - h1.get(0) == h3_height - h3.get(0)) && (h1_height - h1.get(0) == h2_height)) {
                        return h2_height;
                    }
                    h1_height -= h1.get(0);
                    h1.remove(0);
                    h3_height -= h3.get(0);
                    h3.remove(0);
                } else {
                    h2_height -= h2.get(0);
                    h2.remove(0);
                }
            } else if (h2_height == h3_height) {
                if (h2_height > h1_height) {
                    if ((h2_height - h2.get(0) == h1_height - h1.get(0)) && (h2_height - h2.get(0) == h1_height)) {
                        return h1_height;
                    }
                    h2_height -= h2.get(0);
                    h2.remove(0);
                    h3_height -= h3.get(0);
                    h3.remove(0);
                } else {
                    h1_height -= h1.get(0);
                    h1.remove(0);
                }
            } else {
                if (h1_height > h2_height && h1_height > h3_height) {
                    h1_height -= h1.get(0);
                    h1.remove(0);
                } else if (h2_height > h1_height && h2_height > h3_height) {
                    h2_height -= h2.get(0);
                    h2.remove(0);
                } else if (h3_height > h2_height && h3_height > h1_height) {
                    h3_height -= h3.get(0);
                    h3.remove(0);
                }
            }

        } while (h1_height != 0 && h2_height != 0 && h3_height != 0);

        return 0;
    }

}
