import java.io.*;
import java.util.*;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack valueStack, operationStack;

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        String n_ = br.readLine();
        String[] strs_ = n_.trim().split("\\s+");
        int n = Integer.parseInt(strs_[0]);
        int max = 0;
        Solution s = new Solution();

        /**
         * Steps to follow:
         */

        //store query 1 values in value stack.

        //store query 1 and 2 types in operation stack.

        //for query type 4, pop op stack

        //for query 3 print from value stack
    }
}