package main.java.string.Assignment_Problems;
import java.util.*;

public class CampusParkingChargeCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            double charge;

            if (type.equals("BIKE")) {
                charge = hours * 10;
            } else if (type.equals("CAR")) {
                charge = 30 + (hours - 1) * 20;
            } else {
                charge = Math.max(hours * 50, 100);
            }

            total += charge;

            System.out.printf("%s: %.2f%n", type, charge);
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
