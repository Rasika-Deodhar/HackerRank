import java.io.IOException;
import java.util.Scanner;

public class Solution {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        if (n == 2)
            return 0;
        if ((p / 2) < (n - p) / 2 || (p / 2) < ((n + 1) - p) / 2)
            return p / 2;
        return n % 2 == 0 ? ((n + 1) - p) / 2 : (n - p) / 2;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        System.out.println(pageCount(n, p));

        scanner.close();
    }
}
