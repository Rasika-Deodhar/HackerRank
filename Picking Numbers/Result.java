import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER. The function accepts
     * INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        Collections.sort(a);
        int subset_length = 0, subset_length_prev = 0;
        int i = 0, j = 1;

        while (i < a.size()) {
            subset_length = 0;
            while (j < a.size() && a.get(j) - a.get(i) <= 1) {
                j++;
                subset_length++;
                if (subset_length == 1)
                    subset_length++;
            }
            if (subset_length == 1)
                subset_length++;
            if (subset_length > subset_length_prev)
                subset_length_prev = subset_length;

            i = j;
            j++;
        }

        return subset_length_prev;
    }

}