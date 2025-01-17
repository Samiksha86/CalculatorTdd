package com.Assessment_tdd;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public static int add(String string){
        if (string == null || string.isEmpty()) {
            return 0; // Return 0 if the input string is null or empty
        }

        List<Integer> numbers = Arrays.stream(string.split(",|\n")) // Split by ',' or '\n'
                .map(Integer::parseInt) // Convert each part to an integer
                .collect(Collectors.toList());

        return numbers.stream()
                .reduce(0, Integer::sum); // Sum up all integers
    }

}
