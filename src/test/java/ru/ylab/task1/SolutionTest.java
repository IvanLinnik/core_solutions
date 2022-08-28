package ru.ylab.task1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static ru.ylab.task1.Solution.*;

class SolutionTest {
    private static final String ERROR_ARGS_ARRAY = "The number of rows and columns must be greater than 0.";
    private static final String ERROR_EMPTY_ARRAY = "Array must be not empty or null.";
    private static final long[][] POSITIVE = {
            {5, 22, 6, 9, 10, 25},
            {25, 89, 91, 36, 77, 14},
            {30, 84, 71, 56, 90, 30},
            {59, 181, 33, 11, 13, 225},
            {9, 18, 5, 11, 13, 2}
    };

    private static final long[][] NEGATIVE = {
            {-5, -22, -6, -9, -10, -25},
            {-25, -89, -91, -36, -77, -14},
            {-30, -84, -71, -56, -90, -30},
            {-59, -181, -33, -11, -13, -225},
            {-9, -18, -5, -11, -13, -2}
    };

    @Test
    void whenArrayPositiveAndMaxValueIs225() {
        assertThat(findMaxValue(POSITIVE)).isEqualTo(225);
    }

    @Test
    void whenArrayNegativeAndMaxValueIsMinus2() {
        assertThat(findMaxValue(NEGATIVE)).isEqualTo(-2);
    }

    @Test
    void whenArrayPositiveAndMinIs2() {
        assertThat(findMinValue(POSITIVE)).isEqualTo(2);
    }

    @Test
    void whenArrayNegativeAndMinIsMinus225() {
        assertThat(findMinValue(NEGATIVE)).isEqualTo(-225);
    }

    @Test
    void whenArrayPositiveAndAverageIs45() {
        assertThat(findAverageValue(POSITIVE)).isEqualTo(45.0);
    }

    @Test
    void whenArrayNegativeAndAverageIsMinus45() {
        assertThat(findAverageValue(NEGATIVE)).isEqualTo(-45.0);
    }

    @Test
    void whenArrayIsEmpty() {
        long[][] array = new long[0][0];
        assertThatThrownBy(() -> findAverageValue(array))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_EMPTY_ARRAY);
    }

    @Test
    void whenArrayIsNull() {
        long[][] array = null;
        assertThatThrownBy(() -> findAverageValue(array))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_EMPTY_ARRAY);
    }

    @Test
    void whenIncorrectArgumentForArray() {
        assertThatThrownBy(() -> getArrayWithRandomNumbers(10, 0, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_ARGS_ARRAY);
    }

}
