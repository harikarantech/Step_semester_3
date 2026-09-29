package main.java.string.Assignment_Problems;

import java.util.*;
import java.time.LocalDate;

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String plan = sc.next();
            String name = sc.next();
            String startDate = sc.next();

            LocalDate date = LocalDate.parse(startDate);

            int days;

            if (plan.equals("BASIC")) {
                days = 30;
            } else if (plan.equals("STANDARD")) {
                days = 90;
            } else {
                days = 365;
            }

            LocalDate renewalDate = date.plusDays(days);

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}