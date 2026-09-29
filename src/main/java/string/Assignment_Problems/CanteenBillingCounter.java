package main.java.string.Assignment_Problems;

import java.util.*;

public class CanteenBillingCounter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            double finalAmount;

            if (type.equals("STUDENT")) {
                finalAmount = amount * 0.90;
            } else if (type.equals("STAFF")) {
                finalAmount = amount * 0.95;
            } else {
                finalAmount = amount + 10;
            }

            total += finalAmount;

            System.out.printf("%s: %.2f%n", type, finalAmount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}

