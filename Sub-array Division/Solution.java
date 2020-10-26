import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {

        if (s.size() < m) {
            return 0;
        }

        int sum = 0;

        if (s.size() == m) {
            for (Integer integer : s) {
                sum += integer.intValue();
            }

            if (sum == d)
                return 1;
            return 0;
        }

        int count = 0;

        for (int i = 0; i < s.size() && (i + m) <= s.size(); i++) {
            List<Integer> temp = s.subList(i, i + m);
            sum=0;

            for (Integer integer : temp) {
                sum += integer.intValue();
            }
            if (sum == d)
                count++;
        }

        return count;

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Integer> s = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            s.add(sc.nextInt());
        }

        Integer[] dm = new Integer[2];
        dm[0] = sc.nextInt();
        dm[1] = sc.nextInt();

        int d = dm[0].intValue();

        int m = dm[1].intValue();

        int result = birthday(s, d, m);

        System.out.println(result);

        sc.close();
    }
}
