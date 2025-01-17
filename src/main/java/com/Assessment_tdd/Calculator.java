package com.Assessment_tdd;

public class Calculator {

    public static int add(String string){
        if(!string.isEmpty()) {
            return Integer.parseInt(string);
        }

        return  0;
    }
}
