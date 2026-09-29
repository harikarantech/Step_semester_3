package main.java.string.Practice_Problems;

import java.util.*;

public class ExaminationQuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            List<String> parts = new ArrayList<>();

            boolean insideQuotes = false;
            StringBuilder current = new StringBuilder();

            for (int j = 0; j < line.length(); j++) {

                char ch = line.charAt(j);

                if (ch == '"') {
                    insideQuotes = !insideQuotes;
                } 
                else if (ch == ' ' && !insideQuotes) {

                    if (current.length() > 0) {
                        parts.add(current.toString());
                        current.setLength(0);
                    }

                } 
                else {
                    current.append(ch);
                }
            }

            if (current.length() > 0) {
                parts.add(current.toString());
            }

            String type = parts.get(0);
            String correctAnswer;
            String studentAnswer;
            double points;

            if (type.equals("MCQ") || type.equals("TF")) {

                correctAnswer = parts.get(2);
                studentAnswer = parts.get(3);
                points = Double.parseDouble(parts.get(4));

                double score;

                if (studentAnswer.equals(correctAnswer)) {
                    score = points;
                } else {
                    score = 0;
                }

                totalScore += score;

                System.out.printf("%s: %.2f%n", type, score);

            } 
            else {

                correctAnswer = parts.get(2);
                studentAnswer = parts.get(3);
                points = Double.parseDouble(parts.get(4));

                String[] keywords = correctAnswer.split(",");

                int count = 0;

                for (String keyword : keywords) {

                    keyword = keyword.trim().toLowerCase();

                    if (studentAnswer.toLowerCase().contains(keyword)) {
                        count++;
                    }
                }

                double score;

                if (count >= 2) {
                    score = points * 0.75;
                } 
                else if (count == 1) {
                    score = points * 0.50;
                } 
                else {
                    score = 0;
                }

                totalScore += score;

                System.out.printf("%s: %.2f%n", type, score);
            }
        }

        System.out.printf("Total Score: %.2f%n", totalScore);

        sc.close();
    }
}