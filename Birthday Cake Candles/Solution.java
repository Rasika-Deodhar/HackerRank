import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static int birthdayCakeCandles(List<Integer> candles) {
        // Write your code here
        Map<Integer, Integer> result = new HashMap<>();

        if (candles.size() == 0)
            return 0;

        for (Integer integer : candles) {
            if (!result.containsKey(integer)) {
                result.put(integer, Integer.valueOf(1));
                continue;
            }
            result.put(integer, result.get(integer) + 1);
        }

        Integer max_value = Integer.valueOf(0);
        for (Integer integer : result.keySet()) {
            max_value = Integer.max(max_value, integer);
        }

        return result.get(max_value).intValue();
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int candlesCount = sc.nextInt();
        List<Integer> candles = new ArrayList<>();

        while (candlesCount-- > 0) {
            candles.add(sc.nextInt());
        }

        System.out.println(Solution.birthdayCakeCandles(candles));

        sc.close();
    }
}
