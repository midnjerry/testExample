package com.example.testExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// TDD test Driven Development
// Red
// Green
// Refactor


class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    public void setup(){
        stringCalculator = new StringCalculator();
    }


    @Test
    public void emptyStringReturns0() {
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    public void singleDigitStringReturnNumber(){
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    public void differentSingleDigitStringReturnNumber(){
        assertEquals(2, stringCalculator.add("2"));
    }

    @Test
    public void twoNumbersAreAddedTogether(){
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    public void fiveNumbersAreAddedTogether(){
        assertEquals(32, stringCalculator.add("1,2,6,3,20"));
    }

    @Test
    public void newlinesTreatedAsComma(){
        assertEquals(6, stringCalculator.add("1,2\n3"));
    }

    @Test
    public void repeatingSeparatorsThrowError(){
        Assertions.assertThrows(CalculatorException.class, () -> {
            stringCalculator.add("2,\n3");
        });
    }

    @Test
    public void separatorAtEndThrowError(){
        Assertions.assertThrows(CalculatorException.class, () -> {
            stringCalculator.add("2,3,");
        });
    }

    @Test
    public void newlineAtEndThrowError(){
        Assertions.assertThrows(CalculatorException.class, () -> {
            stringCalculator.add("2,3\n");
        });
    }
}