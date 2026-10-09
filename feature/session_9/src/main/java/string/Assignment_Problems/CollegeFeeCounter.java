package main.java.string.Assignment_Problems;
import java.util.*;

interface BusUser {
    double transportFee();
}

abstract class Student {
    String name;

    Student(String name) {
        this.name = name;
    }

    abstract double fee();
}

class DayScholar extends Student implements BusUser {
    DayScholar(String name) {
        super(name);
    }

    public double transportFee() {
        return 12000;
    }

    double fee() {
        return 40000 + transportFee();
    }
}

class Hosteller extends Student {
    Hosteller(String name) {
        super(name);
    }

    double fee() {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser {
    Scholar(String name) {
        super(name);
    }

    public double transportFee() {
        return 12000;
    }

    double fee() {
        return 20000 + transportFee();
    }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Student> students = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");

            switch (s[0]) {
                case "DAY_SCHOLAR":
                    students.add(new DayScholar(s[1]));
                    break;
                case "HOSTELLER":
                    students.add(new Hosteller(s[1]));
                    break;
                case "SCHOLAR":
                    students.add(new Scholar(s[1]));
                    break;
            }
        }

        for (Student student : students) {
            double fee = student.fee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);
        sc.close();
    }
}
