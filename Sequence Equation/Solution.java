import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    private static HashMap<Integer, Integer> hm_1 = new HashMap<>();

    static int getKeyFromValue(int value) {
        for (Integer integer : hm_1.keySet()) {
            if (hm_1.get(integer).equals(value))
                return integer;
        }
        return -1;
    }

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {
        int[] result = new int[p.length];
        for (int i = 1; i <= p.length; i++) {
            if (!hm_1.containsKey(i))
                hm_1.put(i, p[i - 1]);
        }

        int j = 0;
        for (int i = 1; i <= p.length; i++) {
            int val1 = getKeyFromValue(i);
            int val2 = getKeyFromValue(val1);
            result[j++] = val2;
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int[] result = permutationEquation(p);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print("\n");
            }
        }

        scanner.close();
    }
}
