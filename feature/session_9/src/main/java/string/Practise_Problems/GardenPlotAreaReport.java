package main.java.string.Practise_Problems;
import java.util.*;

abstract class Plot {
    String owner;

    Plot(String owner) {
        this.owner = owner;
    }

    abstract double area();

    String shape() {
        return getClass().getSimpleName().toUpperCase();
    }
}

class Circle extends Plot {
    double radius;

    Circle(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Plot {
    double length, width;

    Rectangle(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    double area() {
        return length * width;
    }
}

class Triangle extends Plot {
    double base, height;

    Triangle(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    double area() {
        return 0.5 * base * height;
    }
}

public class GardenPlotAreaReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Plot> plots = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().trim().split("\\\\s+");

            switch (s[0]) {
                case "CIRCLE":
                    plots.add(new Circle(s[1],
                        Double.parseDouble(s[2])));
                    break;
                case "RECTANGLE":
                    plots.add(new Rectangle(s[1],
                        Double.parseDouble(s[2]),
                        Double.parseDouble(s[3])));
                    break;
                case "TRIANGLE":
                    plots.add(new Triangle(s[1],
                        Double.parseDouble(s[2]),
                        Double.parseDouble(s[3])));
                    break;
            }
        }

        for (Plot p : plots) {
            System.out.printf("%s (%s): %.2f%n",
                p.owner, p.shape(), p.area());
            total += p.area();
        }

        System.out.printf("Total Area: %.2f%n", total);
        sc.close();
    }
}