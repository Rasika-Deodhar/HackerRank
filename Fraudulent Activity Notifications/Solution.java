import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int[] trailing_days = new int[2];
        trailing_days[0] = 0;
        trailing_days[1] = d - 1;
        double median_double = 0;
        int notifications = 0;
        List<Integer> trailing_days_array = new ArrayList<>(d);

        for (int j = trailing_days[0]; j <= trailing_days[1]; j++) {
            trailing_days_array.add(expenditure[j]);
        }

        for (int i = d; i < expenditure.length && trailing_days[1] < expenditure.length - 1; i++) {

            // get (median * 2)
            trailing_days_array.sort(Comparator.naturalOrder());
            if (trailing_days_array.size() % 2 == 0) {
                median_double = trailing_days_array.get((trailing_days_array.size() / 2) - 1)
                        + trailing_days_array.get(trailing_days_array.size() / 2);
            } else {
                median_double = trailing_days_array.get(trailing_days_array.size() / 2) * 2;
            }

            // check if (median * 2) <= expenditure value
            if (median_double <= expenditure[i])
                notifications++;

            // set trailing days array and values
            if (!trailing_days_array.isEmpty()) {
                trailing_days_array.remove(trailing_days_array.indexOf(expenditure[trailing_days[0]++]));
            }
            trailing_days_array.add(expenditure[++trailing_days[1]]);
        }

        return notifications;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        System.out.println(activityNotifications(expenditure, d));

        scanner.close();
    }
}
