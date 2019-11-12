import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries, int m) {

        long[] a = new long[n];
        for(int i=0; i<n;i++){
            a[i] = 0;
        }
        
        for(int i=0; i<m; i++){
            for(int j=(queries[i][0]-1); j<=(queries[i][1]-1); j++){
                a[j] += queries[i][2];
            }
        }

        long indexArrayCount=0;
        for(int i=0; i < n; i++){
            if(a[i] > indexArrayCount){
                indexArrayCount = a[i];
            }
            System.out.print(a[i] + " ");
        }
    
        return indexArrayCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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
