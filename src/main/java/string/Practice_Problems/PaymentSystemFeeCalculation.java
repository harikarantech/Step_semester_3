package main.java.string.Practice_Problems;

import java.util.*;

public class PaymentSystemFeeCalculation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            double adjustedAmount;

            if (type.equals("CARD")) {
                adjustedAmount = amount * 1.02;
            } 
            else if (type.equals("WALLET")) {
                adjustedAmount = amount * 1.01;
            } 
            else {
                adjustedAmount = amount;
            }

            total += adjustedAmount;

            System.out.printf("%s: %.2f%n", type, adjustedAmount);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}