import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {

    // Complete the bonAppetit function below.
    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sharedItemCost = 0, bActual;

        for (int i = 0; i < bill.size(); i++) {
            if (i == k)
                continue;
            sharedItemCost += bill.get(i);
        }

        bActual = sharedItemCost / 2;

        if (bActual == b)
            System.out.println("Bon Appetit");
        else
            System.out.println(b - bActual);
    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String[] nk = sc.nextLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        List<Integer> bill = Stream.of(sc.nextLine().replaceAll("\\s+$", "").split(" ")).map(Integer::parseInt)
                .collect(toList());

        int b = Integer.parseInt(sc.nextLine().trim());

        bonAppetit(bill, k, b);

        sc.close();
    }
}
