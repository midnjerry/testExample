package com.example.testExample;

import java.util.Arrays;

public class StringCalculator {
    public int add(String s) {
        if (s == ""){
            return 0;
        }

        String commas = s.replaceAll("\n", ",");
        if (commas.charAt(s.length()-1) == ','){
            throw new CalculatorException("Can't use separator at end");
        }
        String[] numbers = commas.split(",");

        int total = 0;
        
        try {
           total = Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
        } catch (NumberFormatException e){
            throw new CalculatorException("Numbers must be separated by a valid separator");
        }
        return total;
    }
    // int Add(string numbers)
}
