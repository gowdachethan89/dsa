package com.practice.dsa.arrays;

import java.util.*;

public class Day1 {
    public static void main(String[] args) {
        int[] arr = {1, 5, -4};
        findMinAndMax(arr);
        findSecondHeighestElement(arr);
        arrayIsSorted(arr);
        sumOfElements(arr);
    }

    private static void sumOfElements(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("Sum: " + sum);
    }

    private static void arrayIsSorted(int[] arr) {
        if (arr == null) return;
        if (arr.length <= 1) {
            System.out.println("Array is Sorted");
            return;
        }
        boolean sorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            System.out.println("Array is Sorted");
        } else {
            System.out.println("Array is not Sorted");
        }
    }

    private static void findSecondHeighestElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        System.out.println("Max: " + max);
        System.out.println("Second Max: " + secondMax);
    }

    private static void findMinAndMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println("min: " + min + ", max: " + max);
    }
}
