package main.java.string.Practise_Problems;
import java.util.*;
abstract class LibraryItem {
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double fine();
}

class Book extends LibraryItem {
    Book(String title, int days) {
        super(title, days);
    }

    double fine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    DVD(String title, int days) {
        super(title, days);
    }

    double fine() {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class Magazine extends LibraryItem {
    Magazine(String title, int days) {
        super(title, days);
    }

    double fine() {
        return daysLate;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<LibraryItem> items = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");
            int days = Integer.parseInt(s[2]);

            switch (s[0]) {
                case "BOOK":
                    items.add(new Book(s[1], days));
                    break;
                case "DVD":
                    items.add(new DVD(s[1], days));
                    break;
                case "MAGAZINE":
                    items.add(new Magazine(s[1], days));
                    break;
            }
        }

        for (LibraryItem item : items) {
            System.out.printf("%s: %.2f%n",
                item.title, item.fine());
            total += item.fine();
        }

        System.out.printf("Total Fines: %.2f%n", total);
        sc.close();
    }
}
