package ru.ylab.task1;

/*
Сделать два коммита. Один для Таск1 второй для Таск2. Делать коммит в ветке девелоп, затем мердж реквест(уточнить что это и как делать)
*/

import java.util.Objects;

public class Solution {
    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String BLACK = "\u001B[30m";
    private static final String GREEN = "\u001B[32m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    private static final String[] COLORS = {RED, YELLOW, BLUE, BLACK, PURPLE, CYAN, GREEN, WHITE};

    private static final String ERROR_ARGS_ARRAY = "The number of rows and columns must be greater than 0.";
    private static final String ERROR_EMPTY_ARRAY = "Array must be not empty or null.";

    public static void main(String[] args) {
        long[][] array = getArrayWithRandomNumbers(10, 10, 100);
        printArray(array);
        System.out.printf("Maximum value in the array - %d.%n"
                        + "Minimum value in the array - %d.%n"
                        + "Average value in the array - %.2f.%n",
                findMaxValue(array), findMinValue(array), findAverageValue(array));
    }

    public static long[][] getArrayWithRandomNumbers(int rows, int columns, int bound) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException(ERROR_ARGS_ARRAY);
        }
        long[][] array = new long[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = generateRandomNumber(bound);
            }
        }
        return array;
    }

    public static long findMaxValue(long[][] array) {
        validate(array);
        long max = Long.MIN_VALUE;
        for (long[] row : array) {
            for (long value : row) {
                if (value > max) {
                    max = value;
                }
            }
        }
        return max;
    }

    public static long findMinValue(long[][] array) {
        validate(array);
        long min = Long.MAX_VALUE;
        for (long[] row : array) {
            for (long value : row) {
                if (value < min) {
                    min = value;
                }
            }
        }
        return min;
    }

    public static double findAverageValue(long[][] array) {
        validate(array);
        long sum = 0;
        int count = 0;
        for (long[] row : array) {
            for (long value : row) {
                sum += value;
                count++;
            }
        }
        return (double) sum / count;
    }

    private static void validate(long[][] array) {
        if (Objects.isNull(array) || array.length == 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_ARRAY);
        }
    }

    private static long generateRandomNumber(int bound) {
        long random = ((System.nanoTime() * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1));
        return random % bound;
    }

    private static void printArray(long[][] array) {
        for (long[] row : array) {
            for (long value : row) {
                System.out.print(getRandomColor() + value + "\t");
            }
            System.out.println(RESET);
        }
    }

    private static String getRandomColor() {
        return COLORS[(int) generateRandomNumber(COLORS.length)];
    }

}
