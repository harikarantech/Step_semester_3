package main.java.string.Practise_Problem;


class Student {
    String name;
    int[] marks;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    double calculateAverage() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return (double) total / marks.length;
    }

    char calculateGrade() {
        double average = calculateAverage();

        if (average >= 75) {
            return 'B';
        } else if (average >= 60) {
            return 'C';
        } else if (average >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }

    void displayResult() {
        System.out.printf("%s: Average %.1f, Grade %c%n",
                name.toUpperCase(),
                calculateAverage(),
                calculateGrade());
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Student s1 = new Student("Asha",
                new int[]{80, 90, 70});
        Student s2 = new Student("Ravi",
                new int[]{60, 55, 50});

        s1.displayResult();
        s2.displayResult();
    }
}
    
