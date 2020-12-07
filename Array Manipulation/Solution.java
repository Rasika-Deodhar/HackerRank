import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries, int m) {

        // Non-optimized solution
        // long[] a = new long[n];
        // for(int i=0; i<n;i++){
        // a[i] = 0;
        // }

        // for(int i=0; i<m; i++){
        // for(int j=(queries[i][0]-1); j<=(queries[i][1]-1); j++){
        // a[j] += queries[i][2];
        // }
        // }

        // long indexArrayCount=0;
        // for(int i=0; i < n; i++){
        // if(a[i] > indexArrayCount){
        // indexArrayCount = a[i];
        // }
        // System.out.print(a[i] + " ");
        // }

        // return indexArrayCount;

        // Another approach
        long[] a = new long[n];
        long max = 0, sum = 0;

        for (int i = 0; i < m; i++) {

            //Similar - unoptimized
            // for (int j = queries[i][0] - 1; j < queries[i][1]; j++) {
            // a[j] += queries[i][2];
            // if (a[j] > max) {
            // max = a[j];
            // }
            // }

            // Rodney Shag's approach:
            //Add k to left boundary, subtract k in right boundary, nothing in between values
            a[queries[i][0] - 1] += queries[i][2];
            a[queries[i][1]] -= queries[i][2];
        }

        //find sum of array and check if max value is reached.
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (max < sum)
                max = sum;
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries, m);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();
        System.out.println("result=" + result);

        scanner.close();
    }
}
