package main.java.com.eyrealex.core;

public class CalculateGrade {

    public char determineLetterGrade(int grade) {

        if (grade < 0) {
            throw new IllegalArgumentException("Number cannot be less than 0");
        }
        if (grade < 60) {
            return 'F';
        }
        if (grade < 70) {
            return 'D';
        }
        if (grade < 80) {
            return 'C';
        }
        if (grade < 90) {
            return 'B';
        }
        return 'A';
    }

}
