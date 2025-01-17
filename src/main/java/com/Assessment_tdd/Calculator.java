package com.Assessment_tdd;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    public static int add(String string) {
        if (string.isEmpty()) {
            return 0;
        }

        List<Integer> list = strArrayToIntList(getSplit(string));
        negatives(list);
        return list.stream().reduce(0, Integer::sum);
    }

    private static void negatives(List<Integer> list) {
        List<Integer> negativeNumbers = list.stream()
                .filter(num -> num < 0)
                .collect(Collectors.toList());

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers);
        }
    }

    private static List<Integer> strArrayToIntList(String[] strArray) {
        return Arrays.stream(strArray)
                .filter(s -> !s.isEmpty())
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] getSplit(String string) {
        if (string.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n?(.*)").matcher(string);
            if (matcher.matches()) {
                String delimiter = matcher.group(1);
                String toSplit = matcher.group(2);
                // Split using custom delimiter OR comma OR newline
                return toSplit.split("[" + Pattern.quote(delimiter) + ",\n]");
            }
        }
        return string.split("[,\n]");
    }
}