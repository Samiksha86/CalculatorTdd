package com.Assessment_tdd;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {

    public static int add(String string) {
        if(!string.isEmpty()) {
            List<Integer> list = strArrayToIntList(getSplit(string));

			negatives(list);
            return list.stream().reduce(Integer::sum).orElseThrow();
        }
        return 0;

    }

    private static void negatives(List<Integer> list) {
        List<Integer> negativeNumbers = list.stream()
                .filter(num -> num < 0) // Filter negative numbers
                .collect(Collectors.toList());

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }
    }


    private static List<Integer> strArrayToIntList(String[] strArray) {
        return Arrays.stream(strArray).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String[] getSplit(String string) {
        if (string.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n?(.*)").matcher(string);
            if (matcher.matches()) {
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                return toSplit.split(Pattern.quote(delimiter));
            }
        }
        return string.split(",|\n");
    }
}
