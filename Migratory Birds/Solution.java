import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {

        if (arr.size() == 0)
            return 0;

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (Integer integer : arr) {
            if (!hm.containsKey(integer))
                hm.put(integer, 1);
            else
                hm.put(integer, (hm.get(integer) + 1));
        }

        Map.Entry<Integer, Integer> maxEntry = null;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
                maxEntry = entry;
            else if (entry.getValue().compareTo(maxEntry.getValue()) == 0
                    && entry.getKey().compareTo(maxEntry.getKey()) < 0)
                maxEntry = entry;
        }

        return maxEntry.getKey().intValue();
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int arrCount = sc.nextInt();

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < arrCount; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(migratoryBirds(arr));
        sc.close();
    }
}
