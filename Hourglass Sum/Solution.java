import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int sumHourglassMatrix(int rows, int cols, int[][] arr) {
        int sum = 0;

        for (int i = rows; i <= rows + 2; i++) {
            for (int j = cols; j <= cols + 2; j++) {
                if(i==rows || i==rows+2 || (i==rows+1 && j==cols+1))
                    sum += arr[i][j];
            }
        }

        return sum;
    }

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {

        if (arr[0].length < 3 || arr[1].length < 3) {
            return 0;
        }

        int rows = arr[0].length;
        int cols = arr[1].length;
        int rows_hgs = 1 + (rows - 3);
        int cols_hgs = 1 + (cols - 3);

        ArrayList<Integer> store = new ArrayList<>(rows_hgs * cols_hgs);
        int[][] store1 = new int[rows_hgs][cols_hgs];
        int i1=0, j1=0;

        for (int i = 0; i < rows; i++) {
            if (i == arr[0].length || (i + 2) == arr[0].length)
                break;
            for (int j = 0; j < cols; j++) {
                if (j == arr[1].length || (j + 2) == arr[1].length)
                    break;
                store.add(sumHourglassMatrix(i, j, arr));
                store1[i1][j1] = sumHourglassMatrix(i, j, arr);
                j1++;
                // if(arr[i+2][0]!=null && arr[0][j+2]!=null){

                // }
                
            }
            j1=0;
            i1++;
        }

        // for(int i=0; i< rows_hgs; i++){
        //     for(int j=0; j< cols_hgs; j++){
        //         System.out.print(store1[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        return Collections.max(store).intValue();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
