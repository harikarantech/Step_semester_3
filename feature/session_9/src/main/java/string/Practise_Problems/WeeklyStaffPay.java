package main.java.string.Practise_Problems;
import java.util.*;

abstract class Staff {
    String name;

    Staff(String name) {
        this.name = name;
    }

    abstract double pay();
}

class FullTime extends Staff {
    double salary;

    FullTime(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    double pay() {
        return salary;
    }
}

class Hourly extends Staff {
    double hours, rate;

    Hourly(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    double pay() {
        return Math.min(hours, 40) * rate
             + Math.max(0, hours - 40) * rate * 1.5;
    }
}

class Intern extends Staff {
    double stipend;

    Intern(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    double pay() {
        return stipend;
    }
}

public class WeeklyStaffPay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Staff> staffList = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");

            switch (s[0]) {
                case "FULLTIME":
                    staffList.add(new FullTime(s[1],
                        Double.parseDouble(s[2])));
                    break;
                case "HOURLY":
                    staffList.add(new Hourly(s[1],
                        Double.parseDouble(s[2]),
                        Double.parseDouble(s[3])));
                    break;
                case "INTERN":
                    staffList.add(new Intern(s[1],
                        Double.parseDouble(s[2])));
                    break;
            }
        }

        for (Staff s : staffList) {
            System.out.printf("%s: %.2f%n", s.name, s.pay());
            total += s.pay();
        }

        System.out.printf("Total Payroll: %.2f%n", total);
        sc.close();
    }
}
