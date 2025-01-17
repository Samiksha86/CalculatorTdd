package com.Assessment_tdd;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void additionForEmpty(){
        Assertions.assertThat(Calculator.add("")).isEqualTo(0);
    }

    @Test
    void additionForOneInput() {
        Assertions.assertThat(Calculator.add("5")).isEqualTo(5);
    }

    @Test
    void additionForTwoInput() {
    }

    @Test
    void additionForMultipleInput() {
    }

    @Test
    void additionSplitByCommasAndNewLine() {
    }
    @Test
    void additionForDelimeter() {
    }

    @Test
    void additionForNegative() {
    }

}