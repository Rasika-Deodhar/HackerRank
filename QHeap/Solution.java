import java.util.*;

public class Solution {

    static LinkedList<Integer> heap = new LinkedList<Integer>();

    public static void qHeap(final int a, final int b) {

        // 1-add, 2-delete, 3-display minimum

        switch (a) {
            case 1:
                heap.add(b);
                Collections.sort(heap);
                break;
            case 2:
                heap.remove(Integer.valueOf(b));
                break;
            case 3:
                // System.out.println(Collections.min(heap));
                System.out.println(heap.element());
                break;
        }
    }

    public static void main(final String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        final Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // in.nextInt();
        while (n > 0) {

            final String a, b;
            final int a1, b1;

            final String arr1 = in.nextLine();
            final String[] arrStr = arr1.split(" ");

            if (arrStr.length == 2) {
                a = arrStr[0];
                b = arrStr[1];
                a1 = Integer.parseInt(a);
                b1 = Integer.parseInt(b);
                qHeap(a1, b1);
            } else {
                a = arrStr[0];
                a1 = Integer.parseInt(a);
                qHeap(a1, 0);
            }

            n--;
        }

        in.close();
    }
}
