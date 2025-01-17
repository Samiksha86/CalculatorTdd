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
        Assertions.assertThat(Calculator.add("2,5")).isEqualTo(7);
    }

    @Test
    void additionForMultipleInput() {
        Assertions.assertThat(Calculator.add("2,5,3")).isEqualTo(10);
    }

    @Test
    void additionSplitByCommasAndNewLine() {
        Assertions.assertThat(Calculator.add("2,5,3\n5")).isEqualTo(15);
    }
    @Test
    void additionForDelimeter() {
    }

    @Test
    void additionForNegative() {
    }

}