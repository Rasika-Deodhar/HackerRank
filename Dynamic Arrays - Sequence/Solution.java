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
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY. The function accepts
     * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here

        List<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>(n);
        List<Integer> output = new ArrayList<Integer>();
        int lastAnswer = 0;

        for (List<Integer> list : queries) {
            // int index = Xor(list.get(1), lastAnswer) % n;
            int index = (list.get(1) ^ lastAnswer) % n;
            if (list.get(0) == 1) {
                if (seqList.isEmpty()) {
                    seqList.add(new ArrayList<Integer>());
                    seqList.get(0).add(list.get(2));
                } else {
                    try {
                        seqList.get(index);
                    } catch (Exception e) {
                        // TODO: handle exception
                        seqList.add(new ArrayList<Integer>());
                        seqList.get(index).add(list.get(2));
                    }
                    // seqList.get(index).add(list.get(2));// for seqList index=1, make a list then
                    // add element
                }

            } else {
                ArrayList<Integer> seq = seqList.get(index);
                lastAnswer = (list.get(2) % seq.size());
                System.out.println(lastAnswer);
                output.add(lastAnswer);
            }
        }

        return output;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt).collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(result.stream().map(Object::toString).collect(joining("\n")) + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
