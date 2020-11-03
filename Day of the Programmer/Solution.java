import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        LinkedHashMap<String, Integer> hm = new LinkedHashMap<String, Integer>();
        hm.put("January", 31);
        hm.put("February", 28);
        hm.put("March", 31);
        hm.put("April", 30);
        hm.put("May", 31);
        hm.put("June", 30);
        hm.put("July", 31);
        hm.put("August", 31);
        hm.put("September", 30);
        hm.put("October", 31);
        hm.put("November", 30);
        hm.put("December", 31);

        String month = "";
        int dayCount = 0, dayOfTheProgrammer = 0;

        if (year >= 1700 && year <= 1917) {
            for (Entry<String, Integer> m : hm.entrySet()) {
                if ((dayCount + m.getValue().intValue()) < 256)
                    dayCount += m.getValue().intValue();
                else {
                    dayOfTheProgrammer = 256 - dayCount;
                    // month = new StringBuilder(m.getKey());
                    int val = Arrays.asList(hm.keySet().toArray()).indexOf(m.getKey()) + 1;
                    month = val < 10 ? String.valueOf(0) + String.valueOf(val) : String.valueOf(val);
                    break;
                }
            }
            if (year % 4 == 0) {
                dayOfTheProgrammer--;
            }
        } else if (year >= 1919) {
            for (Entry<String, Integer> m : hm.entrySet()) {
                if ((dayCount + m.getValue().intValue()) < 256)
                    dayCount += m.getValue().intValue();
                else {
                    dayOfTheProgrammer = 256 - dayCount;
                    int val = Arrays.asList(hm.keySet().toArray()).indexOf(m.getKey()) + 1;
                    month = val < 10 ? String.valueOf(0) + String.valueOf(val) : String.valueOf(val);
                    break;
                }
            }
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                dayOfTheProgrammer--;
            }

        } else {
            dayCount = -13;
            for (Entry<String, Integer> m : hm.entrySet()) {
                if ((dayCount + m.getValue().intValue()) < 256)
                    dayCount += m.getValue().intValue();
                else {
                    dayOfTheProgrammer = 256 - dayCount;
                    int val = Arrays.asList(hm.keySet().toArray()).indexOf(m.getKey()) + 1;
                    month = val < 10 ? String.valueOf(0) + String.valueOf(val) : String.valueOf(val);
                    break;
                }
            }
        }

        return String.valueOf(dayOfTheProgrammer) + "." + month + "." + String.valueOf(year);

    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int year = Integer.parseInt(sc.nextLine());

        System.out.println(dayOfProgrammer(year));

        sc.close();
    }
}
