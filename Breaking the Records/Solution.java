import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {

        int min_score = scores[0], max_score = scores[0], best_record_break = 0, worst_record_break = 0;

        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max_score) {
                max_score = scores[i];
                best_record_break++;
            } else if (scores[i] < min_score) {
                min_score = scores[i];
                worst_record_break++;
            }
            System.out.println(
                    scores[i] + " " + max_score + " " + min_score + " " + best_record_break + " " + worst_record_break);
        }

        return new int[] { best_record_break, worst_record_break };

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scanner.close();
    }
}
