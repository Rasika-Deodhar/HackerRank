import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY. The function accepts
     * following parameters: 1. INTEGER n 2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

        List<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>(n);
        List<Integer> output = new ArrayList<Integer>();
        int lastAnswer = 0;

        for (int i = 0; i < n; i++) {
            seqList.add(new ArrayList<Integer>());
        }

        for (List<Integer> list : queries) {
            if (list.get(0) == Integer.valueOf(1)) {
                seqList.get((list.get(1) ^ lastAnswer) % n).add(list.get(2));
            } else if (list.get(0) == Integer.valueOf(2)) {
                ArrayList<Integer> seq = seqList.get((list.get(1) ^ lastAnswer) % n);
                lastAnswer = seq.get(list.get(2) % seq.size());
                output.add(lastAnswer);
                // System.out.println(lastAnswer);
            }
        }

        return output;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String[] str_ = str.split(" ");

        int n = Integer.valueOf(str_[0]).intValue();
        int q = Integer.valueOf(str_[1]).intValue();

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            queries.add(Stream.of(sc.nextLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                    .collect(toList()));
        });

        List<Integer> result = Result.dynamicArray(n, queries);
        for (Integer integer : result) {
            System.out.println(integer);
        }

        sc.close();
    }
}
