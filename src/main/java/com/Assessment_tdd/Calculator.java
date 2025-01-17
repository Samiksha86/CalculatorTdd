package com.Assessment_tdd;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    public static int add(String string) {
        if (string == null || string.isEmpty()) {
            return 0; // Return 0 if the input string is null or empty
        }

        List<Integer> list = strArrayToIntList(getSplit(string));
        return list.stream()
                .reduce(0, Integer::sum); // Sum up all integers
    }

    private static List<Integer> strArrayToIntList(String[] strArray) {
        return Arrays.stream(strArray)
                .map(Integer::parseInt) // Convert strings to integers
                .collect(Collectors.toList());
    }

    private static String[] getSplit(String string) {
        if (string.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n?(.*)").matcher(string); // \n is optional
            if (matcher.matches()) {
                String delimiter = matcher.group(1); // Custom delimiter
                String toSplit = matcher.group(2);  // Remaining string to split
                return toSplit.split(Pattern.quote(delimiter));
            }
        }
        return string.split(",|\n"); // Default delimiters: ',' and '\n'
    }
}
