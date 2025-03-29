package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            list.add(x);
        }
        Collections.sort(list);
        System.out.print(list.get(n - 1));
        if (n % 2 == 1) {
            System.out.print(" " + list.get(n / 2) + " ");
        }
        else {
            double mid = (list.get(n / 2) + list.get(n / 2 - 1)) / 2.0;
            if (mid == (int)mid) {
                System.out.printf(" %.0f ", mid);
            }
            else {
                System.out.printf(" %.1f ", mid);
            }
        }
        System.out.print(list.get(0));
    }
}
