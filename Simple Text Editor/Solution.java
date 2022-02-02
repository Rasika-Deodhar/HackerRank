import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class Solution {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Stack<String> valueStack = new Stack<>();
    private static Stack<HashMap<Integer, String>> operationStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */

        String n_ = br.readLine();
        String[] strs_ = n_.trim().split("\\s+");
        int n = Integer.parseInt(strs_[0]);

        /**
         * Steps to follow:
         */

        while (n-- > 0) {
            String lines = br.readLine();
            String[] strs = lines.trim().split("\\s+");
            int type = Integer.parseInt(strs[0]);
            if (type == 1) {
                String _s = strs[1];
                String[] s = _s.trim().split("\\s+");
                for (String string : s) {
                    valueStack.push(string);
                }
                operationStack.push(new HashMap<Integer, String>() {
                    {
                        put(1, _s);
                    }
                });

            } else if (type == 2 && valueStack.peek() != null) {
                int a = Integer.parseInt(strs[1]);
                String s = "";
                while (--a > 0 && valueStack.peek() != null) {
                    valueStack.pop();
                }
                Iterator i = valueStack.iterator();
                while (i.hasNext()) {
                    System.out.println(i.next());
                }
                operationStack.push(new HashMap<Integer, String>() {
                    {
                        put(2, valueStack.peek());
                    }
                });
            } else if (type == 3 && valueStack.peek() != null) {
                Iterator i = valueStack.iterator();
                int a = Integer.parseInt(strs[1]);
                while (i.hasNext() && --a > 0) {
                    i.next();
                }
                System.out.println(i.next());
            } else if (type == 3 && operationStack.peek() != null) {
                HashMap<Integer, String> h = operationStack.pop();
                if (h.containsKey(1)) {
                    String s = h.get(1);
                    for (String string : s) {
                        valueStack.push(string);
                    }
                }

                else
                    valueStack.push(h.get(2));
            }
        }

        // store query 1 values in value stack.

        // store query 1 and 2 types in operation stack.

        // for query type 4, pop op stack

        // for query 3 print from value stack
    }
}