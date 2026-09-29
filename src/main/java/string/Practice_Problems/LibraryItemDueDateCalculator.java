package main.java.string.Practice_Problems;

import java.util.*;
import java.time.LocalDate;

public class LibraryItemDueDateCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            int firstSpace = line.indexOf(' ');
            String type = line.substring(0, firstSpace);

            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            int days;

            if (type.equals("BOOK")) {
                days = 14;
            } 
            else if (type.equals("DVD")) {
                days = 7;
            } 
            else {
                days = 3;
            }

            LocalDate dueDate = currentDate.plusDays(days);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}