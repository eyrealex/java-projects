package main.java.com.eyrealex.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculateGradeTest {

    @Test
    void determineLetterGrade_lessThanSixty_returnF() {
        var grade = new CalculateGrade();
        assertEquals('F', grade.determineLetterGrade(59));
    }

    @Test
    void determineLetterGrade_lessThanSeventy_returnD() {
        var grade = new CalculateGrade();
        assertEquals('D', grade.determineLetterGrade(69));
    }

    @Test
    void determineLetterGrade_lessThanEighty_returnC() {
        var grade = new CalculateGrade();
        assertEquals('C', grade.determineLetterGrade(79));
    }

    @Test
    void determineLetterGrade_lessThanNinety_returnB() {
        var grade = new CalculateGrade();
        assertEquals('B', grade.determineLetterGrade(89));
    }

    @Test
    void determineLetterGrade_hundredOrLess_returnA() {
        var grade = new CalculateGrade();
        assertEquals('A', grade.determineLetterGrade(99));
    }

    @Test
    void determineLetterGrade_ninety_returnA() {
        var grade = new CalculateGrade();
        assertEquals('A', grade.determineLetterGrade(90));
    }

    @Test
    void determineLetterGrade_eighty_returnB() {
        var grade = new CalculateGrade();
        assertEquals('B', grade.determineLetterGrade(80));
    }

    @Test
    void determineLetterGrade_seventy_returnC() {
        var grade = new CalculateGrade();
        assertEquals('C', grade.determineLetterGrade(70));
    }

    @Test
    void determineLetterGrade_sixty_returnD() {
        var grade = new CalculateGrade();
        assertEquals('D', grade.determineLetterGrade(60));
    }

    @Test
    void determineLetterGrade_lessThanZero_returnException() {
        var grade = new CalculateGrade();
        assertThrows(IllegalArgumentException.class,
                () -> {
                    grade.determineLetterGrade(-1);
                });
    }
}