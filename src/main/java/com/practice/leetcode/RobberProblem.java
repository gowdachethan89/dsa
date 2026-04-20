package com.practice.leetcode;

import java.util.Arrays;

public class RobberProblem {
    public static void main(String[] args) {
//        int[] arr = {2,7,9,3,1};
        int[] arr = {1,2,3,1};
        int k = 2;
//        System.out.println(minCapability(arr, k));
        System.out.println(rob(arr));

    }

    public static int rob(int[] nums) {
        int prev2 = 0;//0,1,2,
        int prev1 = 0;//1,2,3,
        for(int amount: nums){
            int current = Math.max(prev1, amount + prev2);
            prev2 = prev1;
            prev1 = current;
            System.out.println("prev2: " + prev2 + " , prev1: " + prev1  + " , amount: " + amount + " , current: " + current);
        }
        return prev1;
    }

    public static int minCapability(int[] nums, int k) {
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        // Find search range
        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canRob(nums, k, mid)) {
                ans = mid;       // valid answer
                high = mid - 1;  // try smaller
            } else {
                low = mid + 1;   // increase cap
            }
        }
        return ans;
    }

    private static boolean canRob(int[] nums, int k, int capability) {
        System.out.println("nums : " + Arrays.toString(nums) + ", k: " + k + ", capability: " + capability);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                count++;
                i++; // Skip the next house to maintain non-adjacency
            }
            if (count >= k) return true;
        }
        return false;
    }
}
