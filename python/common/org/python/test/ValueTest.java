package org.python.test;

import org.python.types.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ValueTest{

    public static void main(String[] args) {

        int[] array = {99, 88, 55, 77, 1, 66};

        System.out.print("unsorted data: ");
        printArray(array);

        System.out.print("ascending order: "); //1,55,66,77,88,99
        bubble_sort(array);

        printArray(array);

        System.out.print("descending order: "); //99,88,77,66,55,1
        bubble_sort(array, false);

        printArray(array);

    }

    private static void bubble_sort(int[] input) {
        bubble_sort(input, true);
    }

    private static void bubble_sort(int[] input, boolean ascending) {

        int inputLength = input.length;
        int temp;
        boolean is_sorted;

        for (int i = 0; i < inputLength; i++) {

            is_sorted = true;

            for (int j = 1; j < (inputLength - i); j++) {

                if (ascending) {
                    if (input[j - 1] > input[j]) {
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                        is_sorted = false;
                    }
                } else {
                    if (input[j - 1] < input[j]) {
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;
                        is_sorted = false;
                    }

                }

            }

            // is sorted? then break it, avoid useless loop.
            if (is_sorted) break;

        }

    }

    private static void printArray(int[] data) {
        String result = Arrays.stream(data)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(result);
    }

}