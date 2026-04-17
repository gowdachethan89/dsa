package com.practice.dsa.arrays;

import java.util.HashMap;

import static java.lang.Character.isLetterOrDigit;

public class Day2 {
    public static void main(String[] args) {
        int[] arr = {1, -1, 4, 5};
        int target = 5;
//        System.out.println(Arrays.toString(moveZerosToEnd(arr)));
//        System.out.println(Arrays.toString(moveAllNegativeNumbers(arr)));
//        System.out.println(Arrays.toString(removeDuplicates(arr)));
//        System.out.println(Arrays.toString(twoSum(arr, target)));
//        System.out.println(Arrays.toString(twoSumUsingMap(arr, target)));
//        System.out.println(containerWithMostWater(arr));
        String str = "a$22a";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str){
        if(str.isEmpty()) throw new IllegalArgumentException("Not a valid String");
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            while(left < right && isLetterOrDigit(str.charAt(left))){
                left++;
            }
            while(left < right && isLetterOrDigit(str.charAt(right))){
                right--;
            }
            if(str.charAt(left) != str.charAt(right)){
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private static int containerWithMostWater(int[] arr) {
        int maxArea = 0;
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int minHeight = Math.min(arr[left], arr[right]);
            int width = right - left;
            int area = minHeight * width;
            maxArea = Math.max(maxArea, area);
            if(arr[left] < arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }

    private static int[] moveAllNegativeNumbers(int[] arr) {
        if(arr == null || arr.length == 0) throw new IllegalArgumentException("Pass Proper elements");
        int p = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                int temp = arr[i];
                arr[i] = arr[p];
                arr[p] = temp;
                p++;
            }
        }
        return arr;
    }

    private static int[] twoSumUsingMap(int[] arr, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int remaining = target - arr[i];
            if(map.containsKey(remaining)) {
                return new int[]{map.get(remaining), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1};
    }

    private static int[] twoSum(int[] arr, int target){
        int left = 0;
        int right = arr.length - 1;
        while(left < right){
            int sum = arr[left] + arr[right];
            if(sum == target){
                return new int[]{left,right};
            } else if (sum < target){
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
    
    private static int[] moveZerosToEnd(int[] arr) {
        if(arr == null || arr.length == 0) return arr;
        int p = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                int temp = arr[p];
                arr[p] = arr[i];
                arr[i] = temp;
                p++;
            }
        }
        return arr;
    }

    private static int[] removeDuplicates(int[] arr) {
        if(arr == null || arr.length == 0) return new int[]{};
        int p = 0;
        for(int i =1; i < arr.length; i++){
            if(arr[i] != arr[p]){
                p++;
                arr[p] = arr[i];
            }
        }
        int[] result = new int[p + 1];
        System.arraycopy(arr, 0, result, 0, p + 1);
        return result;
    }
}
