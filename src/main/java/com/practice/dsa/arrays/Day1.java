package com.practice.dsa.arrays;

import java.util.*;

public class Day1 {
    public static void main(String[] args) {
        int[] arr = {1, 5, -4};
        System.out.println(Arrays.toString(findMinAndMax(arr)));
        System.out.println(Arrays.toString(findSecondHighestElement(arr)));
        System.out.println(arrayIsSorted(arr));
        System.out.println(sumOfElements(arr));
    }

    private static int sumOfElements(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    private static boolean arrayIsSorted(int[] arr) {
        if (arr == null || arr.length < 1) return false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private static int[] findSecondHighestElement(int[] arr) {
        if (arr == null || arr.length <= 1) {
            //return new int[]{-1, -1}; //edge case
            throw new IllegalArgumentException("Array is empty");
        }
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
        if (secondMax == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second highest element");
        }
        return new int[]{max, secondMax};
    }

    private static int[] findMinAndMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return new int[]{};
        }
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
        return new int[]{min, max};
    }
}
