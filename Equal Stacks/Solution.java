import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int n1 = in.nextInt();

        int n2 = in.nextInt();

        int n3 = in.nextInt();

        ArrayList<Integer> h1 = new ArrayList<Integer>();
        while (n1-- > 0) {
            int i = in.nextInt();
            h1.add(i);
        }
        ArrayList<Integer> h2 = new ArrayList<Integer>();
        while (n2-- > 0) {
            int i = in.nextInt();
            h2.add(i);
        }
        ArrayList<Integer> h3 = new ArrayList<Integer>();
        while (n3-- > 0) {
            int i = in.nextInt();
            h3.add(i);
        }

        int result = Result.equalStacks(h1, h2, h3);

        System.out.println();
        System.out.println("The result is - " + result);

        in.close();
    }
}
