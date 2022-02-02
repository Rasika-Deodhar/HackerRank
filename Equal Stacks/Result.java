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

        // Check the total height of all 3 stacks
        // If equal then return height
        // Else
        // If first 2 are same ->
        // If A,B > C -> remove from A and B
        // Else remove from C

        // If first and third are same ->
        // If A,C > B -> Remove from A and C
        // Else remove from B

        // If second and third are same ->
        // If B,C > A -> Remove from B and C
        // Else remove from A

        return 0;
    }

}
