package ru.ylab.task2;

public class Solution {
    private static final String ERROR_EMPTY_ARRAY = "Array must be not empty.";
    private static final String ERROR_ARGS_NEGATIVE = "Arguments \"begin\" and \"end\" must be >= 0.";
    private static final String ERROR_ARGS_LENGTH = "Arguments \"begin\" and \"end\" must be < array.length.";

    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        System.out.println("Not sorted array: ");
        printArray(array);
        System.out.println("Sorted array: ");
        printArray(sort(array, 0, array.length - 1));

    }

    public static int[] sort(int[] array, int begin, int end) {
        validate(array, begin, end);
        int[] result = array.clone();
        quickSort(result, begin, end);
        return result;
    }

    private static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(array, begin, end);

            quickSort(array, begin, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (array[j] <= pivot) {
                i++;

                int swapTemp = array[i];
                array[i] = array[j];
                array[j] = swapTemp;
            }
        }

        int swapTemp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = swapTemp;

        return i + 1;
    }

    private static void validate(int[] array, int begin, int end) {
        if (array.length == 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_ARRAY);
        }
        if (begin < 0 || end < 0) {
            throw new IllegalArgumentException(ERROR_ARGS_NEGATIVE);
        }
        if (begin >= array.length || end >= array.length) {
            throw new IllegalArgumentException(ERROR_ARGS_LENGTH);
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.println();
    }

}
