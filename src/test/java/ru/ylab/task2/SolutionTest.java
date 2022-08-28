package ru.ylab.task2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static ru.ylab.task2.Solution.sort;

class SolutionTest {
    private static final String ERROR_EMPTY_ARRAY = "Array must be not empty.";
    private static final String ERROR_ARGS_NEGATIVE = "Arguments \"begin\" and \"end\" must be >= 0.";
    private static final String ERROR_ARGS_LENGTH = "Arguments \"begin\" and \"end\" must be < array.length.";

    private static final int[] POSITIVE =
            {5, 22, 6, 9, 10, 25, 10, 22, 77, 77, 3, 1, 1, 5};

    private static final int[] NEGATIVE =
            {-5, -22, -6, -9, -10, -25, -10, -22, -77, -77, -3, -1, -1, -5};

    @Test
    void whenSortPositiveArray() {
        int[] expected = {1, 1, 3, 5, 5, 6, 9, 10, 10, 22, 22, 25, 77, 77};
        assertThat(sort(POSITIVE, 0, POSITIVE.length - 1)).isEqualTo(expected);
    }

    @Test
    void whenSortNegativeArray() {
        int[] expected = {-77, -77, -25, -22, -22, -10, -10, -9, -6, -5, -5, -3, -1, -1};
        assertThat(sort(NEGATIVE, 0, NEGATIVE.length - 1)).isEqualTo(expected);
    }

    @Test
    void whenArrayIsEmpty() {
        int[] array = new int[0];
        assertThatThrownBy(() -> sort(array, 0, array.length - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_EMPTY_ARRAY);
    }

    @Test
    void whenArgumentNegative() {
        assertThatThrownBy(() -> sort(POSITIVE, -1, POSITIVE.length - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_ARGS_NEGATIVE);
    }

    @Test
    void whenArgumentBiggerThenLength() {
        assertThatThrownBy(() -> sort(POSITIVE, 0, POSITIVE.length + 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_ARGS_LENGTH);
    }

}