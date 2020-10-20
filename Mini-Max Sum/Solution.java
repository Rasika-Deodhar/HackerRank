import java.util.Scanner;

public class Solution {

    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        long max_sum = sum - arr[0], min_sum = sum - arr[0];

        for (int i = 0; i < arr.length; i++) {
            long sum_val = sum - arr[i];
            if (sum_val < min_sum) {
                min_sum = sum_val;
            } else if (sum_val > max_sum) {
                max_sum = sum_val;
            }
        }

        System.out.println(min_sum + " " + max_sum);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        miniMaxSum(arr);

        scanner.close();
    }
}
